/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Laboratorios
 */
public class Client{
    
    private String id;
    private String name;
    private String phone;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    ///metodos de acceso
    
    
    public Client(String cedula, String nombre, String numeroTelefono, String direccion) {
        this.id = cedula;
        this.name = nombre;
        this.phone = numeroTelefono;
        this.address = direccion;
    }//constructor
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + '}';
    } //to string

    
}//class
