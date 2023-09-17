import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AlertController, ToastController } from '@ionic/angular';
import { closestTo } from 'date-fns';
import { ApiService } from 'src/app/sevices/api.service';
import { AutenticacionService } from 'src/app/sevices/autenticacion.service';

@Component({
  selector: 'app-cambiar-recuperar',
  templateUrl: './cambiar-recuperar.page.html',
  styleUrls: ['./cambiar-recuperar.page.scss'],
})
export class CambiarRecuperarPage implements OnInit {

  usuarioFormCambiar = {
    usuario:'',
    password: '',
    nueva_password: '',
    conf_nueva_password:''
  }
  
  lista: [{}];
  constructor(public alertController: AlertController,
    public servicio: AutenticacionService,
    public router: Router,
    private apiService: ApiService,
    public toastController: ToastController,
    ) {
      this.apiService.recuperarCredencialesUsuario(localStorage.getItem('mail')).subscribe(data=>{
        console.log(data);
        localStorage.setItem('idUser',data[0].SIN_DV);
      }) 
      // this.apiService.recuperarDatosUsuario(this.apiService.usuarioAuth).subscribe(data=>{
      //   this.lista = [this.apiService.usuarioLogueado];
      //   }
      //   );
      
    }

  ngOnInit() {
    
      
      
  }
  cambiarContrasena(){
    

    let nuevaContrasena = btoa(this.usuarioFormCambiar.nueva_password);
    let confNuevaContrasena = btoa(this.usuarioFormCambiar.conf_nueva_password);

    // console.log(this.apiService.usuarioLogueado.runUsuario);
    // console.log(this.apiService.usuarioLogueado.passwordUsuario);
    // console.log(usuario);
    // console.log(contrasena);
    
    if(nuevaContrasena === '' || confNuevaContrasena === ''){
      this.errorGenerico('Error','Debe completar todos los campos');
    } else{
      
        if(nuevaContrasena === confNuevaContrasena){
          console.log('rut: '+localStorage.getItem('idUser'));
          console.log('contraseña: '+nuevaContrasena);
    
          this.apiService.cambiarClave(localStorage.getItem('idUser'), nuevaContrasena).subscribe(data=>{
            console.log(data);
            if(data === 0){
              this.confirmacion('Bien','Contraseña actualizada');  
              localStorage.setItem('idUser','');
              localStorage.setItem('run','');
              localStorage.setItem('userLogged','');
              this.router.navigate(['login']);
            }else{
              this.errorGenerico('Error','Ha ocurrido un error, por favor intente de nuevo');
            }
            
            
          })
        }else{
          // console.log('contraseñas no coinciden wea');
          this.errorGenerico('Error','Las contraseñas no coinciden');
          
        }
    }   
    
     

    // this.apiService.validarLogin(usuario, contrasena).subscribe( data =>{
    //   if(data.result ==='LOGIN NOK'){
    //     this.presentToastWithOptions('Credenciales incorrectas','Usuario o clave incorrectos, por favor reintente.');
    //   }else{
    //     this.presentToast('Bienvenido!');
        
    //   }
    // });


  }

  atras(){
    this.router.navigate(['recuperar']);
  }
  refresh(){
    window.location.reload();
  }

  async errorGenerico(header, message){
    const toast = await this.toastController.create({
      header: header,
      message: message,
      position: 'top',
      duration: 2500,
      color: 'danger',
      icon: 'information-circle',
      cssClass: 'errorGenerico',//terminar estilo
      buttons: ['Aceptar']
    });
    toast.present();
  }
  
  async confirmacion(header, message) {
    const toast = await this.toastController.create({
      position: 'top',
      header: header,
      message: message,
      icon:'checkmark',
      duration: 1500
    });
    toast.present();
  }

  
  async presentarAlerta(header, message) {
    const toast = await this.toastController.create({
      header: header,
      message: message,
      icon: 'information-circle',
      position: 'top',
      buttons: [
       {
          text: 'Aceptar',
          role: 'cancel',
          handler: () => {

          }
        }
      ]
    });
    await toast.present();

    const { role } = await toast.onDidDismiss();
    console.log('onDidDismiss resolved with role', role);
  }





}
