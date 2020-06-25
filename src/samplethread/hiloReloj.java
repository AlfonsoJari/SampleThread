package samplethread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextField;

public class hiloReloj implements Runnable {

    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");

    private boolean estado;
    private JTextField txtR;
    private int m = 0;
    private int s = 0;

    public hiloReloj(JTextField t) {
        this.txtR = t;
    }
    
    public void detener(){
        this.estado = false;
    }

    private String formato() {
        String hora = "";
        if (s==60 && m==60){
            s=0;
            m=0;
        }
        if (s < 60) {
            if (s < 10 && m < 10) {
                hora = "0" + m + ":0" + s;
                return hora;
            }
            if (s < 10) {
                hora = m + ":0" + s;
                return hora;
            }
            if (m < 10) {
                hora = "0" + m + ":" + s;
                return hora;
            }
            hora = m + ":" + s;
            return hora;
        } else {
            s=0;
            m++;
            if (m < 10) {
                hora = "0" + m + ":0" + s;
                return hora;
            }
            hora = m + ":0" + s;
            return hora;
        }
    }

    public void masS() {
        this.s = this.s+10;
    }
    
    public void masM() {
        this.m = this.m+1;
    }
    

    @Override
    public void run() {
        estado=true;
        while (estado) {
            try {
                Thread.sleep(1000);
                s++;
                txtR.setText(formato());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
