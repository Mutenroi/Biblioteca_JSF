/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean
public class FileUploadView {
    
    private String destino = "K:\\JSF\\Biblioteca\\web\\resources\\Imagenes\\";
    private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
            String ex = getFile().getFileName();
            try{
               TransferFile(ex, getFile().getInputstream());
            }catch(IOException e){
                FacesMessage message = new FacesMessage("Fail", file.getFileName() + " isn't uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            FacesMessage message = new FacesMessage("Fail", file.getFileName() + " isn't exist");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void upload2(FileUploadEvent  event) {
        if(event.getFile() != null) {
            String ex = event.getFile().getFileName();
            try{
               TransferFile2(ex, event.getFile().getInputstream(), event);
            }catch(IOException e){
                FacesMessage message = new FacesMessage("Fail", event.getFile().getFileName() + " isn't uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            FacesMessage message = new FacesMessage("Fail", event.getFile().getFileName() + " isn't exist");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    private void TransferFile(String fileName, InputStream in) {
        try{
           OutputStream out = new FileOutputStream(new File(destino + fileName));
           int reader = 0;
           byte[] bytes = new byte[(int)getFile().getSize()];
           while((reader = in.read(bytes)) != -1){
               out.write(bytes, 0, reader);
           }
           in.close();
           out.flush();
           out.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    private void TransferFile2(String fileName, InputStream in, FileUploadEvent event) {
        try{
           OutputStream out = new FileOutputStream(new File(destino + fileName));
           int reader = 0;
           byte[] bytes = new byte[(int)event.getFile().getSize()];
           while((reader = in.read(bytes)) != -1){
               out.write(bytes, 0, reader);
           }
           in.close();
           out.flush();
           out.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
