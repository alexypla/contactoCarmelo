package com.example.usuario.contactoscarmelo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    private File getInternaPrivada(String archivo) {

        File directory = context.getFilesDir();
        File file = new File(directory, archivo);
        return file;
    }
    private File getExternaPrivada(String archivo) {
        File file = new File(context.getExternalFilesDir(
                null), archivo);
        return file;
    }

    private boolean write(File f, String texto){
        boolean written=true;
        FileWriter fw=null;

        try{
            fw=new FileWriter(f);
            fw.write(texto);
            fw.flush();//vacia el buffer
            fw.close();


        }
        catch(IOException e){written=false;
            Log.v(TAG,e.toString());}
        return written;
    }
    private void pedirPermisos(){
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_CONTACTS)) {
                AlertDialog.Builder build= new AlertDialog.Builder(this);
                build.setMessage("necesito los permisos para escribir");
                build.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        permisos();
                    }
                });
                build.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"No tengo Permisos",Toast.LENGTH_SHORT).show();
                    }
                });
                build.create().show();

            }
        }
    }
    private void permisos(){ActivityCompat.requestPermissions(MainActivity.this,
            new String[]{Manifest.permission.READ_CONTACTS},
            0);}
}
