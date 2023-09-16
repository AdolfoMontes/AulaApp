
package controlador;

import com.raven.theme.ImageAvatar;
import static controlador.I_Aplicacion.VERSION;
import db.Conexion;
import ds.desktop.notify.DesktopNotify;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Comuna;
import modelo.Curso;
import modelo.EstadoCivil;
import modelo.Nivel;
import modelo.Ocupacion;
import modelo.Parentesco;
import modelo.Persona;
import modelo.PuebloOriginario;
import modelo.Region;
import modelo.Rol;
import modelo.Sexo;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import javaswingdev.Notification;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.TableColumn;
import modelo.Asignatura;
import modelo.Bloque;
import modelo.Sala;


public class ControladorInterfaz {
    public void filtro(String consulta, JTable jtableBuscar, int columna){
        DefaultTableModel dm = (DefaultTableModel)jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+consulta, columna));
        }
        
    public void contarRegistros(JTable tabla, JLabel label){
            label.setText(String.valueOf(tabla.getRowCount()));
            
        }

    public void newFilter(String box1, String box2, String box3, JTable jtable) {
        RowFilter<Object, Object> rf = null;
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jtable.getModel());
        List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(3);
        int cont = 0;
        if (!box1.isBlank()) {
            cont++;
            filters.add(RowFilter.regexFilter(box1, 0));
        }

        if (!box2.isBlank()) {
            cont++;
            filters.add(RowFilter.regexFilter(box2, 1));
        }

        if (!box3.isBlank()) {
            cont++;
            filters.add(RowFilter.regexFilter(box3, 7));
        }
        try {
            rf = RowFilter.andFilter(filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        if (cont != 0) {
            sorter.setRowFilter(rf);
        }
        jtable.setRowSorter(sorter);

    }
        
    public void cargarCbPueblo(JComboBox cb){
        ControladorPuebloOriginario c = new ControladorPuebloOriginario();
        ArrayList<PuebloOriginario> lista = c.puebloListar();
        for (PuebloOriginario p : lista) {
                cb.addItem(p);
        }
    }
    public void cargarCbSexo(JComboBox cb){
        ControladorSexo cs = new ControladorSexo();
        ArrayList<Sexo> lista = cs.sexoListar();
        for (Sexo s : lista) {
                cb.addItem(s);
        }
    }
    
    public void cargarCbRegion(JComboBox cb){
        ControladorDireccion cs = new ControladorDireccion();
        ArrayList<Region> lista = cs.regionListar();
        for (Region r : lista) {
                cb.addItem(r);
        }
    }
    public void cargarCbComuna(JComboBox cb, int regionId){
        ControladorDireccion cs = new ControladorDireccion();
        ArrayList<Comuna> lista = cs.comunaListar(regionId);
        for (Comuna r : lista) {
                cb.addItem(r);
        }
    }
    public void cargarCbEstadoCivil(JComboBox cb){
        ControladorEstadoCivil cs = new ControladorEstadoCivil();
        ArrayList<EstadoCivil> lista = cs.estadoListar();
        for (EstadoCivil r : lista) {
                cb.addItem(r);
        }
    }
    public void cargarCbParentesco(JComboBox cb){
        ControladorParentesco cs = new ControladorParentesco();
        ArrayList<Parentesco> lista = cs.parentescoListar();
        for (Parentesco r : lista) {
                cb.addItem(r);
        }
    }
    public void cargarCbOcupacion(JComboBox cb){
        ControladorOcupacion cs = new ControladorOcupacion();
        ArrayList<Ocupacion> lista = cs.ocupacionListar();
        for (Ocupacion r : lista) {
                cb.addItem(r);
        }
    }
    public void cargarCbNivel(JComboBox cb){
        ControladorNivel cs = new ControladorNivel();
        ArrayList<Nivel> lista = cs.nivelListar();
        for (Nivel r : lista) {
                cb.addItem(r);
        }
    }
    public void cargarCbDocente(JComboBox cb){
        ControladorPersona cs = new ControladorPersona();
        ArrayList<Persona> lista = cs.listarDocentes();
        for (Persona r : lista) {
                cb.addItem(r);
        }
    }
    public void cargarCbRol(JComboBox cb, int tipo){
        ControladorRol cs = new ControladorRol();
        ArrayList<Rol> lista = cs.rolListar(tipo);
        for (Rol r : lista) {
                cb.addItem(r);
        }
    }
    public void limiteCaracteres(JTextField cajadeTexto, int limite){
        String texto=cajadeTexto.getText();
        if(texto.length()>limite){
            cajadeTexto.setText(texto.substring(0,limite));
        }
    }
    public void limiteCaracteres(JTextArea cajadeTexto, int limite){
        String texto=cajadeTexto.getText();
        if(texto.length()>limite){
            cajadeTexto.setText(texto.substring(0,limite));
        }
    }
    
    public static int setSelectedValue(JComboBox comboBox, int value)
    {
        PuebloOriginario item;
        for (int i = 0; i < comboBox.getItemCount(); i++)
        {
            item = (PuebloOriginario)comboBox.getItemAt(i);
            if (item.getId()== value)
            {
                comboBox.setSelectedIndex(i);
                return 1; //Encontrado!
            }

            
        }
        return 0; 
    }
    
    public static int setSelectedValueSexo(JComboBox comboBox, int value)
    {
        Sexo item;
        for (int i = 0; i < comboBox.getItemCount(); i++)
        {
            item = (Sexo)comboBox.getItemAt(i);
            if (item.getId()== value)
            {
                comboBox.setSelectedIndex(i);
                return 1; //Encontrado!
            }

            
        }
        return 0; 
    }
    
     public static int setSelectedValueComuna(JComboBox comboBox, String value)
    {
        Comuna item;
        for (int i = 0; i < comboBox.getItemCount(); i++)
        {
            item = (Comuna)comboBox.getItemAt(i);
            if (item.getNom_comuna().equals(value.trim()))
            {
                comboBox.setSelectedIndex(i);
                return 1; //Encontrado!
            }

            
        }
        return 0; 
    }
     
    public static int setSelectedValueRol(JComboBox comboBox, int value)
    {
        Rol item;
        for (int i = 0; i < comboBox.getItemCount(); i++)
        {
            item = (Rol)comboBox.getItemAt(i);
            if (item.getId()==value)
            {
                comboBox.setSelectedIndex(i);
                return 1; //Encontrado!
            }

            
        }
        return 0; 
    }
    public static int setSelectedValueRegion(JComboBox comboBox, String value)
    {
        Region item;
        for (int i = 0; i < comboBox.getItemCount(); i++)
        {
            item = (Region)comboBox.getItemAt(i);
            if (item.getNom_region().equals(value.trim()))
            {
                comboBox.setSelectedIndex(i);
                return 1; //Encontrado!
            }

            
        }
        return 0; 
    }
    
    public void eliminarColumna(JTable tabla, int columna) {
        tabla.getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getColumnModel().getColumn(columna).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(columna).setMinWidth(0);
    }
    
    public void cargarCbCurso(JComboBox cb){
        ControladorCurso cc = new ControladorCurso();
        ArrayList<Curso> lista = cc.cursoListar();
        for (Curso r : lista) {
            cb.addItem(r);
        }
    }
    
    public void cargarCbCursoTodo(JComboBox cb){
        ControladorCurso cc = new ControladorCurso();
        ArrayList<Curso> lista = cc.cursoListarTodo();
        for (Curso r : lista) {
             cb.addItem(r);
        }
    }
    
    public void cargarCbCursoTodo(JList list){
        ControladorCurso cc = new ControladorCurso();
        DefaultListModel listmodel = new DefaultListModel();
        ArrayList<Curso> lista = cc.cursoListarTodo();
        for (Curso r : lista) {
             listmodel.addElement(r.getId()+ ":" + r.toString());
        }
        list.setModel(listmodel);
    }
    public void cargarCbCurso2(JComboBox cb){
        ControladorCurso cc = new ControladorCurso();
        ArrayList<Curso> lista = cc.cursoListar();
        for (Curso r : lista) {
            cb.addItem(r.getCod_curso());
        }
    }
    public void cargarCbAlumnos(JComboBox cb, int anio, int idnivel){
        ControladorPersona cc = new ControladorPersona();
        ArrayList<Persona> lista = cc.listarAlumno(anio, idnivel);
        for (Persona r : lista) {
            cb.addItem(r);
        }
    }
    
     public void cargarCbBloque(JComboBox cb, int idDia){
        ControladorBloque cc = new ControladorBloque();
        ArrayList<Bloque> lista = cc.bloqueListar(idDia);
        for (Bloque r : lista) {
            cb.addItem(r);
        }
    }
     public void cargarCbSala(JComboBox cb){
        ControladorSala cc = new ControladorSala();
        ArrayList<Sala> lista = cc.salaListar();
        for (Sala r : lista) {
            cb.addItem(r);
        }
    }
    public void cargarCbAsignatura(JComboBox cb, Curso curso){
        ControladorAsignatura ca = new ControladorAsignatura();
        ArrayList<Asignatura> lista = ca.listarAsignaturaPorCurso(curso);
        for (Asignatura r : lista) {
            System.out.println(r.getCod_asignatura());
            cb.addItem(r);
        }
    }
    public void cargarCbAlumnosporCurso(JComboBox cb, int idcurso){
        cb.removeAllItems();
        ControladorPersona cc = new ControladorPersona();
        ArrayList<Persona> lista = cc.listarAlumnodeCurso(idcurso);
        for (Persona r : lista) {
            cb.addItem(r);
        }
    }
    
    
    public File abrirFileChooser(JFrame ventana, JTextField txt, ImageAvatar label){
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        ControladorUsuario cu = new ControladorUsuario();
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Imagenes(*.jpg, *.jpeg, *.png)", "jpg", "jpeg", "png"); 
        filechooser.setFileFilter(imgFilter);
        int result = filechooser.showOpenDialog(ventana);
        File archivo=null;
        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = filechooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                txt.setText("...");
            } else {
                txt.setText(fileName.getAbsolutePath());
                cu.ponerImagenenLabel(fileName.getAbsolutePath(), label);
                archivo = filechooser.getSelectedFile();
                
            }
        }return archivo;
    }
    
    
    public int guardarImagen(File ruta, int run, ImageAvatar label){
        Conexion conexion = new Conexion();
        File saveLocation = new File("./profilephoto.jpg");
        try {
            // A partir del objeto File creamos el fichero físicamente
            if (saveLocation.createNewFile())
              System.out.println("El fichero se ha creado correctamente");
            else
              System.out.println("No ha podido ser creado el fichero");
          } catch (IOException ioe) {
            ioe.printStackTrace();
          }
        try(Connection con = conexion.getConnection()){
            String insertar = "UPDATE USUARIO SET FOTO=? WHERE RUN=? ";
            BufferedImage img;
            BufferedImage imgResultante;
            imgResultante=ImageIO.read(saveLocation);
            FileInputStream fis = null;
            img=ImageIO.read(ruta);
            Image img2 = img.getScaledInstance(179, 179, Image.SCALE_SMOOTH);
            ImageIcon icon=new ImageIcon(img2);
            label.setImage(icon);
            //label.revalidate();
            //label.repaint();
            img = resize(img, 179, 179);
            ImageIO.write(img, "jpg",saveLocation);
            fis = new FileInputStream(ruta);
            FileInputStream fis2 = new FileInputStream(saveLocation);
            
            PreparedStatement ps = con.prepareStatement(insertar);
            
            ps.setBinaryStream(1, fis2, (int)saveLocation.length());
            ps.setInt(2, run);
            ps.executeUpdate();
            return 0;
        }catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }
    
    
    public int borrarImagen(int run){
        Conexion conexion = new Conexion();
        try(Connection con = conexion.getConnection()){
            String insertar = "UPDATE USUARIO SET FOTO=null WHERE RUN=? ";
            PreparedStatement ps = con.prepareStatement(insertar);
            ps.setInt(1, run);
            ps.executeUpdate();
            return 0;
        }catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }
    
    public int guardarLogo(File ruta, ImageAvatar label){
        Conexion conexion = new Conexion();
        File saveLocation = new File("./logo.jpg");
        try {
            // A partir del objeto File creamos el fichero físicamente
            if (saveLocation.createNewFile())
              System.out.println("El fichero se ha creado correctamente");
            else
              System.out.println("No ha podido ser creado el fichero");
          } catch (IOException ioe) {
            ioe.printStackTrace();
          }
        try(Connection con = conexion.getConnection()){
            String insertar = "UPDATE INSTITUCION SET LOGO=? ";
            BufferedImage img;
            BufferedImage imgResultante;
            imgResultante=ImageIO.read(saveLocation);
            FileInputStream fis = null;
            img=ImageIO.read(ruta);
            Image img2 = img.getScaledInstance(179, 179, Image.SCALE_SMOOTH);
            ImageIcon icon=new ImageIcon(img2);
            label.setImage(icon);
            //label.revalidate();
            //label.repaint();
            img = resize(img, 179, 179);
            ImageIO.write(img, "jpg",saveLocation);
            fis = new FileInputStream(ruta);
            FileInputStream fis2 = new FileInputStream(saveLocation);
            
            PreparedStatement ps = con.prepareStatement(insertar);
            
            ps.setBinaryStream(1, fis2, (int)saveLocation.length());
            ps.executeUpdate();
            return 0;
        }catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }
    
    
        public void recuperarLogo(ImageAvatar label, int pixeles){
        try
        {
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) 
            {
                
                PreparedStatement ps2 = con.prepareStatement("SELECT logo from INSTITUCION ");
                ps2.executeQuery();
                ResultSet rs=ps2.executeQuery();
                Image img = null;
                ImageIcon img2= null;
                if(rs.next())
                {
                    Blob foto = rs.getBlob("logo");
                    if(foto != null){
                        byte[] recuperado = foto.getBytes(1, (int) foto.length());
                        BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(recuperado));
                        img = imagen.getScaledInstance(pixeles, pixeles, Image.SCALE_SMOOTH);
          
                        img2 = new ImageIcon(img);
                    }else{                       
                        img2 = new ImageIcon(getClass().getResource("/iconos/icons8_user_71px.png"));
                        
                    }
                    label.setImage(img2);
                    System.out.println("Acceso a metodo cargarImagen");
                };
                
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    };
    
    public BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }
    
    public void addCheckBox(int column,JTable table)
    {
        TableColumn to = table.getColumnModel().getColumn(column);
        to.setCellEditor(table.getDefaultEditor(Boolean.class));
        to.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }

    public boolean IsSelected(int row, int column, JTable table){
        return table.getValueAt(row,column)!=null;
    }

    public void cargarCbcursosPorDocenteoNivel(JComboBox cb, int runDocente, int idNivel){
        ControladorCurso cc = new ControladorCurso();
        ArrayList<Curso> lista = cc.cursoListarporDocenteoNivel(runDocente, idNivel);
        for (Curso r : lista) {
            cb.addItem(r);
        }
    }
    
    public void cargarCbanios(JComboBox cb){
        ControladorCurso cc = new ControladorCurso();
        ArrayList<String> lista = cc.anioListar();
        for (String r : lista) {
            cb.addItem(r);
        }
    }
    
    public void cargarCbcursoporAnio(JComboBox cb, int anio){
        ControladorCurso cc = new ControladorCurso();
        ArrayList<Curso> lista = cc.listarCursosPorAnio(anio);
        for (Curso r : lista) {
            cb.addItem(r);
        }
    }
    
    public int mostrarupdate(JFrame frame) throws IOException {
        ValidarVersion vv = new ValidarVersion();
        String nuevaversion2 = vv.nuevoUpdate();
        String nuevaversion = nuevaversion2.replaceAll("\\.", "");
        String version = VERSION.replaceAll("\\.", "");
        int validador = 0;
        if(nuevaversion.equals("-2")){
            //JOptionPane.showMessageDialog(frame,"La versión que ejecutas ya no es funcional, por favor actualiza ejecutando AulaAppUpdater.exe");
            System.exit(0);
        }
        else if (Integer.valueOf(nuevaversion) > Integer.valueOf(version)) {
            DesktopNotify.showDesktopMessage("AulaApp", "Hay una nueva versión disponible.\n"
                    + "Versión Actual: " + VERSION + "\n"
                    + "Nueva Versión: " + nuevaversion2, DesktopNotify.TIP, 15000L);
            validador = 1;
        }
        return validador;
    }
}
