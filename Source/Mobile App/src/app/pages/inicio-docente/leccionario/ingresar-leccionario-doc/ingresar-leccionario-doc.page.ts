import { Attribute, Component, OnInit, ViewChild } from '@angular/core';
import { IonDatetime, PickerController, ToastController } from '@ionic/angular';
import { format, parseISO } from 'date-fns';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Asignatura } from 'src/app/interface/asignatura';
import { Leccionario } from 'src/app/interface/leccionario';
import { Router } from '@angular/router';


@Component({
  selector: 'app-ingresar-leccionario-doc',
  templateUrl: './ingresar-leccionario-doc.page.html',
  styleUrls: ['./ingresar-leccionario-doc.page.scss'],
})
export class IngresarLeccionarioDocPage implements OnInit {
  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAsignatura: Asignatura[] = [];
  listaLeccionario: Leccionario[] = [];
  mdl_curso: any;
  mdl_nivel: any;
  mdl_asignatura:any;

  runDocente: string;
  formato =''; 
  txt_descLeccionario = '';
  // id_asignatura: number;
   
  nivel:Nivel;
  usr_creacion:string;
  formatoAsignatura = '';
  lista: [{}];
  @ViewChild(IonDatetime) datetime: IonDatetime

  constructor( public _pickerCtrl: PickerController,
    public apiService: ApiService,
    public toastController: ToastController,
    public router: Router) {

    
  }

  ngOnInit() {
    this.formato = format(parseISO(format(new Date(),  'yyyy-MM-dd')), ' dd-MM-yyyy')
    this.formato = localStorage.getItem('fecha');
    console.log('fecha formato:: '+localStorage.getItem('fecha'))

    this.mdl_asignatura = localStorage.getItem('idAsignatura');
    console.log('id asignatura mdl:: '+this.mdl_asignatura);
    // this.mdl_curso = localStorage.getItem('idCurso');
    // console.log('id curso:: '+localStorage.getItem('idCurso'))
  
  
  this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
    this.lista = [this.apiService.usuarioLogueado];
    // console.log(this.lista);
    this.runDocente = localStorage.getItem('userLogged');
    console.log(this.runDocente);
    
  }
  );
  
  }

 

  onChange(selectedValue){
    console.log("Selected:",selectedValue);


 
  }

  confirmaLeccionario(){
    if(this.txt_descLeccionario === ''){
      this.errorGenerico('Atención!','Todos los campos deben ser llenados!')
    }else{
    //   this.txt_descLeccionario;
    // this.fechaSys;
    // this.formato;
    // this.usr_creacion;
    // this.mdl_asignatura;
    console.log('desc leccionario: ' + this.txt_descLeccionario);//descripcion  
    // console.log('fecha sys: ' + this.fechaSys);//fecha sys
    console.log('fecha leccionario: ' + this.formato);//fecha leccionario
    console.log('usuario creador observacion: ' + this.runDocente);//usuario creador observacion
    console.log('id_asignatura: ' + this.mdl_asignatura);//id asignatura
    // console.log('id curso: ' + this.id_curso);//firma (nombre usuario?)
    // console.log('id curso: ' + this.id_curso);//fecha modificacion
    // console.log('id curso: ' + this.id_curso);//usuario modificacion
    // console.log('id curso: ' + this.id_curso);//fecha firma

    this.apiService.confirmarLeccionario(this.txt_descLeccionario, this.formato, this.runDocente, this.mdl_asignatura).subscribe(data=>{
      console.log(data);
      this.presentToast('Exito!','Leccionario registrado correctamente.');
      this.txt_descLeccionario= '';
      // this.formato= '';
      // this.usr_creacion= '';
      // this.mdl_asignatura= 0;
      localStorage.removeItem('fecha');
      this.router.navigate(['inicio-docente/leccionario']);
      
    })

    }
    

  }

  irInicioDocente(){
    this.router.navigate(['inicio-docente']).then(()=>{
      window.location.reload();
    });
  }

  atras(){
    this.router.navigate(['inicio-docente/leccionario']);
    
  }
  refresh(){
    window.location.reload();
  }

  async presentToast(header,message) {
    const toast = await this.toastController.create({
      header: header,
      position: 'top',
      message: message,
      duration: 3000,
      color: 'success'
    });
    toast.present();
  }

  async presentToastWithOptions(header, message) {
    const toast = await this.toastController.create({
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

  async errorGenerico(tipo, mensaje) {  //Usar este mensaje para evitar crear una por cada tipo.
    const toast = await this.toastController.create({
      header: tipo,
      message: mensaje,
      position: 'top',
      icon: 'close',
      duration:3500,
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
    console.log('onDidDismiss resolved with role', role)
}
}