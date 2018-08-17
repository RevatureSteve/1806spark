// Modules
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Components
import { MainComponent } from './components/main/main.component';
import { NpmComponent } from './components/npm/npm.component';
import { PackageComponent } from './components/package/package.component';
import { CliComponent } from './components/cli/cli.component';
import { TypeScriptComponent } from './components/typescript/typescript.component';
import { AccessComponent } from './components/access/access.component';
import { ClassComponent } from './components/class/class.component';
import { TypesComponent } from './components/types/types.component';
import { DecoratorComponent } from './components/decorator/decorator.component';
import { ModuleComponent } from './components/module/module.component';
import { TemplateComponent } from './components/template/template.component';
import { ComponentComponent } from './components/component/component.component';
import { DirectiveComponent } from './components/directive/directive.component';
import { RoutingComponent } from './components/routing/routing.component';
import { DiComponent } from './components/di/di.component';
import { ServiceComponent } from './components/service/service.component';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { StructuralComponent } from './components/structural/structural.component';
import { PipeComponent } from './components/pipe/pipe.component';
import { HttpComponent } from './components/http/http.component';
import { AngularJSComponent } from './components/angularjs/angularjs.component';
import { JavascriptComponent } from './components/javascript/javascript.component';
import { FlashcardzComponent } from './components/flashcardz/flashcardz.component';

export const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  { path: 'main',  component: MainComponent },
  { path: 'npm',  component: NpmComponent },
  { path: 'package',  component: PackageComponent },
  { path: 'cli',  component: CliComponent },
  { path: 'typescript',  component: TypeScriptComponent },
  { path: 'access',  component: AccessComponent },
  { path: 'class',  component: ClassComponent },
  { path: 'types',  component: TypesComponent },
  { path: 'decorator',  component: DecoratorComponent },
  { path: 'module',  component: ModuleComponent },
  { path: 'template',  component: TemplateComponent },
  { path: 'component',  component: ComponentComponent },
  { path: 'directive',  component: DirectiveComponent },
  { path: 'routing',  component: RoutingComponent },
  { path: 'di',  component: DiComponent },
  { path: 'service',  component: ServiceComponent },
  { path: 'databinding',  component: DatabindingComponent },
  { path: 'structural',  component: StructuralComponent },
  { path: 'pipe',  component: PipeComponent },
  { path: 'http',  component: HttpComponent },
  { path: 'angularjs',  component: AngularJSComponent },
  { path: 'js', component: JavascriptComponent },
  { path: 'fc', component: FlashcardzComponent},
  { path: '**', redirectTo: '/main' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
