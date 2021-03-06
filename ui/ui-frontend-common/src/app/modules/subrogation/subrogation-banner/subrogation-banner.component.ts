/*
 * Copyright French Prime minister Office/SGMAP/DINSIC/Vitam Program (2019-2020)
 * and the signatories of the "VITAM - Accord du Contributeur" agreement.
 *
 * contact@programmevitam.fr
 *
 * This software is a computer program whose purpose is to implement
 * implement a digital archiving front-office system for the secure and
 * efficient high volumetry VITAM solution.
 *
 * This software is governed by the CeCILL-C license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL-C
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
import * as moment_ from 'moment';
import { filter, switchMap } from 'rxjs/operators';

import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';

import { AuthService } from '../../auth.service';
import { ConfirmDialogService } from '../../components/confirm-dialog/confirm-dialog.service';
import { Subrogation } from '../../models';
import { SubrogationService } from '../subrogation.service';

const moment = moment_;

@Component({
  selector: 'vitamui-common-subrogation-banner',
  templateUrl: './subrogation-banner.component.html',
  styleUrls: ['./subrogation-banner.component.scss']
})
export class SubrogationBannerComponent implements OnInit {

  @ViewChild('stopConfirmDialog', { static: true }) stopConfirmDialogTemplateRef: TemplateRef<SubrogationBannerComponent>;

  show = false;
  hidden = false;
  endDate: Date;
  subrogation: Subrogation;
  subrogationTTL = 1800000; // default TTL

  constructor(
    public authService: AuthService,
    private subrogationService: SubrogationService,
    private confirmDialogService: ConfirmDialogService
  ) { }

  ngOnInit() {
    this.authService.userLoaded.pipe(filter((user) => !!user && !!user.superUser))
      .subscribe(() => {
        this.subrogationService.getCurrent().pipe(filter((data) => !!data))
          .subscribe((data) => {
            if (!this.subrogation) {
              this.subrogation = data;
              this.show = true;
              this.endDate = moment(this.subrogation.date).toDate();
              this.subrogationTTL = this.endDate.getTime() - new Date().getTime();
              setTimeout(() => this.authService.logoutAndRedirectToUiForUser(this.authService.user.superUser), this.subrogationTTL);
            }
          });
      });
  }

  onStopSubrogation() {
    this.confirmDialogService.confirm(this.stopConfirmDialogTemplateRef).pipe(
      switchMap(() => this.subrogationService.decline(this.subrogation.id))
    )
      .subscribe(() => {
        this.show = false;
        this.authService.logoutAndRedirectToUiForUser(this.authService.user.superUser);
      });
  }

}
