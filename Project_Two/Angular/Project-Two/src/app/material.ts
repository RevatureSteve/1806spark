import { NgModule } from '@angular/core';
// ts file for the use for Angular Materials
import { MatButtonModule, MatCheckboxModule } from '@angular/material';
import {MatSidenavModule} from '@angular/material/sidenav';

@NgModule({
    imports: [MatButtonModule, MatCheckboxModule, MatSidenavModule],
    exports: [MatButtonModule, MatCheckboxModule, MatSidenavModule],
})
export class MaterialModule { }
