package br.com.fiap.tds2ps.spring_mvc.dto;

public class PatientDto {

    private String cpf;
    private String fullName;
    private String email;
    private String phone;
    private Long cep;
    private String adressComplement;
    private String gender;

    // Getters e Setters
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Long getCep() { return cep; }
    public void setCep(Long cep) { this.cep = cep; }

    public String getAdressComplement() { return adressComplement; }
    public void setAdressComplement(String adressComplement) { this.adressComplement = adressComplement; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
