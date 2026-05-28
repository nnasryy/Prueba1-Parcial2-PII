/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1parcial2;

/**
 *
 * @author nasry
 */
import java.io.File;

public class ManagerdeArchivos {

    private int txt;
    private int javaFiles;
    private int pdf;
    private int otros;

    public void contar(File dir) {
        if (dir == null || !dir.exists()) return;
        File[] archivos = dir.listFiles();
        if (archivos == null) return;
        for (File f : archivos) {
            if (f.isDirectory()) {
                contar(f);
            } else {
                procesarArchivo(f);
            }
        }
    }

    private void procesarArchivo(File f) {
        String nombre = f.getName().toLowerCase();
        if (nombre.endsWith(".txt")) {
            txt++;
        } else if (nombre.endsWith(".java")) {
            javaFiles++;
        } else if (nombre.endsWith(".pdf")) {
            pdf++;
        } else {
            otros++;
        }
    }

    public String buscar(File dir, String texto) {
        String resultados = "";
        if (dir == null || !dir.exists()) return resultados;
        File[] archivos = dir.listFiles();
        if (archivos == null) return resultados;
        for (File f : archivos) {
            if (f.isDirectory()) {
                resultados += buscar(f, texto);
            } else {
                if (f.getName().toLowerCase().contains(texto.toLowerCase())) {
                    resultados += f.getAbsolutePath() + "\n";
                }
            }
        }
        return resultados;
    }

    public int getTxt()       { return txt; }
    public int getJavaFiles() { return javaFiles; }
    public int getPdf()       { return pdf; }
    public int getOtros()     { return otros; }

    public void reset() {
        txt = 0;
        javaFiles = 0;
        pdf = 0;
        otros = 0;
    }
}