import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { AlertController, ToastController} from '@ionic/angular';
import { ApiService } from 'src/app/sevices/api.service';
import { AutenticacionService } from 'src/app/sevices/autenticacion.service';
import { Usuario } from 'src/app/models/usuario.models';
import { Nivel } from 'src/app/interface/nivel';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  usuarioForm = {
    run: '',
    password: ''
  }

  listaUsuarios: [Usuario]
  listaNiveles: [Nivel]
  public mostrarInfo: boolean = false;

  constructor(public alertController: AlertController,
    public servicio: AutenticacionService,
    public router: Router,
    public apiService: ApiService,
    public toastController: ToastController) {

    }
    
    ngOnInit() {
      if(localStorage.getItem('userLogged')!= null){
        this.loginAuto();
      }
  }
  
  mostrarInfoButton(){
    this.mostrarInfo = !this.mostrarInfo;
  }

  loginAuto(){
    this.apiService.validarLogin(localStorage.getItem('userLogged'), localStorage.getItem('userPass')).subscribe( data =>{
      if(data.result ==='LOGIN OK'){
        this.apiService.obtenerUsuariosRol(localStorage.getItem('userLogged')).subscribe(data=>{
          console.log(data);
          if(data[0]['ROL']=== 'Docente'){
            this.router.navigate(['inicio-docente']).then(()=>{
              window.location.reload();
            });
            
          }else if(data[0]['ROL']=== 'Administrador'){
            this.router.navigate(['inicio']);

          }else if(data[0]['ROL']=== 'UTP'){
            this.router.navigate(['inicio']);

          }else if(data[0]['ROL']=== 'Director'){
            this.router.navigate(['inicio']);
          }else{
            console.log('no es ni docente ni admin');
            
          }
        },err=>{
          console.log('error');
          
        });
        
      }
    })
  }

  validarLogin(){
    let run= this.usuarioForm.run;
    let contrasena = btoa(this.usuarioForm.password);
    this.apiService.validarLogin(run, contrasena).subscribe( data =>{
      if(this.usuarioForm.run === '' || this.usuarioForm.password === ''){

      this.presentarAlertaOpciones('Atención!','Los campos no pueden estar vacíos');
   
    }else if(data.result ==='LOGIN NOK'){
      this.presentarAlertaOpciones('Credenciales incorrectas','Usuario o clave incorrectos, por favor reintente.');
      
      
      }else{
        localStorage.setItem('userLogged', run);
        localStorage.setItem('userPass', contrasena);

        this.presentarAlerta('Bienvenido!');
        // this.router.navigate(['inicio']);
        console.log(localStorage.getItem('userLogged'));
        
        this.apiService.obtenerUsuariosRol(localStorage.getItem('userLogged')).subscribe(data=>{
          console.log(data);
          if(data[0]['ROL']=== 'Docente'){
            this.router.navigate(['inicio-docente']);
            
          }else if(data[0]['ROL']=== 'Administrador'){
            this.router.navigate(['inicio']);

          }else if(data[0]['ROL']=== 'UTP'){
            this.router.navigate(['inicio']);

          }else if(data[0]['ROL']=== 'Director'){
            this.router.navigate(['inicio']);
          }else{
            console.log('no es ni docente ni admin');
            
          }
        });
        
        this.usuarioForm.run ="";
        this.usuarioForm.password ="";
        
      }
    },err=>{
      this.presentarAlertaOpciones('Atención!','Los campos no pueden estar vacíos');
    });

  } 
  recuperarContrasena(){
    this.router.navigate(['recuperar']);
  }
  

  async errorGenerico(tipo, mensaje) {  //Usar este mensaje para evitar crear una por cada tipo.
    const alert = await this.alertController.create({
      header: tipo,
      message: mensaje,
      buttons: ['Ok']
    });
    await alert.present();
}



  async presentarAlerta(message) {
    const toast = await this.toastController.create({
      position: 'top',
      message: message,
      duration: 2000,
      color: 'success',
    });
    await toast.present();
  }

  async presentarAlertaOpciones(header, message) {
    const toast = await this.toastController.create({
      message: message,
      icon: 'information-circle',
      position: 'top',
      duration: 3500,
      color: 'danger',
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
