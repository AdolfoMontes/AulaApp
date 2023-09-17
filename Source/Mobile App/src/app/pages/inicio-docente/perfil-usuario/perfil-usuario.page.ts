import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/sevices/api.service';
import { AlertController} from '@ionic/angular';
import { Router } from '@angular/router';
import { Camera, CameraResultType, CameraSource, Photo } from '@capacitor/camera'





@Component({
  selector: 'app-perfil-usuario',
  templateUrl: './perfil-usuario.page.html',
  styleUrls: ['./perfil-usuario.page.scss'],
})
export class PerfilUsuarioPage implements OnInit {
  lista: [{}];

  ruta: string = '';
  
  constructor (private ApiService:ApiService, private alertController: AlertController,
    private router: Router) { }

  ngOnInit() {
    this.ApiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
      this.lista = [this.ApiService.usuarioLogueado];
      }
      );
      
  }

  recuperarContrasena(){
    this.router.navigate(['cambiar']);
  }

  mostrarInfoSobre(){
    this.alertaSobreAulaappTeam(); 

  }

  logOut(){
    this.router.navigate(['login']);
    localStorage.clear();
  }

  irInicioDocente(){
    this.router.navigate(['inicio-docente']).then(()=>{
      window.location.reload();
    });
  }

  atras(){
    this.router.navigate(['inicio-docente']);
  }
  refresh(){
    window.location.reload();
  }

  async alertaSobreAulaappTeam() {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',      
      header: 'Acerca de',
      message: '© 2022 AulaAppTeam. All rights reserved.',
      buttons: ['Aceptar']
    });

    await alert.present();

    const { role } = await alert.onDidDismiss();
    console.log('onDidDismiss resolved with role', role);
  }

}
