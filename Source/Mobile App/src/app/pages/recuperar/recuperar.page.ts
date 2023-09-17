import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AlertController, ToastController } from '@ionic/angular';
import { ApiService } from 'src/app/sevices/api.service';


@Component({
  selector: 'app-recuperar',
  templateUrl: './recuperar.page.html',
  styleUrls: ['./recuperar.page.scss'],
})
export class RecuperarPage implements OnInit {

  mostrarInputCodigo: boolean;
  ocultarEnviarMail: boolean = false;
  nombres: string = '';
  run: number=0;
  mail: string='';
  codigoOtp: number = 0;
  
  
  usuarioForm = {
    run: '',
    mail:'',
    codigoOtp:''
  }
  
  lista: [{}];
  constructor(private router: Router,
    private toastController: ToastController,
    private apiService: ApiService,
    private alertController: AlertController) {}

  ngOnInit() {
    
    
  }

  enviarMail(){
    let run = parseInt(this.usuarioForm.run)
    let mail = this.usuarioForm.mail
    if(run === parseInt('') || mail === ''){
      console.log('campos vacios');
      this.alertaError('Atención!','Los campos no pueden estar vacíos')               
    }else{
      this.apiService.recuperarDatosUsuario(run).subscribe(data=>{
        // console.log(data.result[0]);
        console.log(data);
        // debugger;
        try{
          // console.log(data.result[0]);
          this.run = parseInt(data.result[0][11]);
          this.mail = data.result[0][6];
          this.nombres = data.result[0][1];
          // console.log('RUN parseado: '+this.run);
          // console.log('mail del usuario existente: '+this.mail);
          // console.log('nombres del usuario existente: '+this.nombres);
          // console.log('reconoce usuario correcto pero falta correo');
          if(mail !== this.mail){
            console.log('usuario o mail incorrectos');
            this.alertaError('Atención!','Usuario o Correo inválido, intente nuevamente')               
            this.usuarioForm.run='';
            this.usuarioForm.mail='';
          }            

          else if(mail === this.mail){
            console.log('generar Codigo');
            this.apiService.crearCodigoOtp(this.run, this.mail).subscribe(data =>{
              console.log(data['outBinds'].resultado);
              if(data['outBinds'].resultado === undefined){
                console.log('no puede ser');
              }else{
                console.log('enviar mail');
                this.codigoOtp = data['outBinds'].resultado;
                this.apiService.enviarCorreo(this.nombres, this.mail, this.codigoOtp).subscribe(data=>{
                  console.log('correo enviado');
                  this.envioCorreo('Correo Enviado!','Revisa tu bandeja de entrada o carpeta de Spam!');
                  this.mostrarInputCodigo = true;
                    this.ocultarEnviarMail = true;

                  })               
                }              
            })        
          
          }
          
        }catch{
          console.log('correo inválido o no existe en nuestra base de datos');  
          this.alertaError('Error','Usuario/Correo inválido o no existe en nuestra base de datos')               
          this.usuarioForm.run='';
          this.usuarioForm.mail='';
        }
      }, err=>{
        console.log('completar todos los campos');
        this.alertaError('Error','Debe completar todos los campos para recuperar contraseña')               
        this.usuarioForm.run='';
        this.usuarioForm.mail='';
        
      });
    }
  }

  verificaCodigo(){
    this.apiService.validarCodigo(this.usuarioForm.codigoOtp, this.mail, this.run).subscribe(data=>{
      console.log(data['outBinds'].resultado);
      if(data['outBinds'].resultado === '0'){
        console.log('codigo validado');
        localStorage.setItem('mail',this.mail);
        this.alertaConfirmacion('Éxito!','Código validado correctamente!');               
        this.router.navigate(['cambiar/cambiar-recuperar']);   
      }else{
          if(this.usuarioForm.codigoOtp === ''){
            this.alertaError('Atención','El campo no puede estar vacío');               
    
          }else{

            console.log('codigo invalido');
          this.alertaError('Error','El código ingresado es inválido');               
          }
        
      }
      
    }, err=>{
        this.alertaError('Error','Ha ocurrido un error, intente nuevamente');               

      })
  
  }

  atras(){
    this.router.navigate(['']);
  }

  async alertaGenerica(header, message) {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: header,
      message: message,
      buttons: ['OK']
    });

    await alert.present();
    }
    async alertaError(header, message) {
      const toast = await this.toastController.create({
        header: header,
        message: message,
        icon: 'close-circle-outline',
        position: 'top',
        color: 'danger',
        duration: 2000,
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


  async alertaConfirmacion(header, message) {
    const toast = await this.toastController.create({
      header: header,
      message: message,
      icon: 'checkmark-circle',
      position: 'top',
      color: 'success',
      duration: 2000,
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
  async envioCorreo(header, message) {
    const toast = await this.toastController.create({
      header: header,
      message: message,
      icon: 'checkmark-circle',
      position: 'top',
      color: 'success',
      duration: 3000,
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
