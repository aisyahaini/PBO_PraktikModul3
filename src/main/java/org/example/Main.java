/*Aisyah Nuraini (A11.2022.14161)
A11.44UG1 - Pemrograman Berbasis Objek Praktik
Jumat, 22 Maret 2024
Intellij IDEA*/

package org.example;

import PV.evolution.models.PasswordStore;

public class Main {
    public static void main(String[] args) {
        PasswordStore pass1 = new PasswordStore("Akun BCA", "1122334455", "RahasiaNegara");
        pass1.setCategory(PasswordStore.CAT_WEBAPP);
        System.out.println(pass1);
        System.out.println("\nUSERNAME: "+pass1.username+" \nPASSWORD: "+pass1.getPassword());
    }
}