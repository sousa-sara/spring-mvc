# Sistema de Consulta Médica  

## 📖 Sobre o Projeto  
O **Sistema de Consulta Médica** é uma aplicação **Spring MVC** desenvolvida para facilitar a gestão de consultas médicas de uma clínica de pequeno porte, que necessita de um sistema simples, porém prático e eficiente. A plataforma permite **cadastrar e consultar pacientes** através do CPF, **registrar anamnese e prescrição** desse paciente, além de **exibir um histórico médico** caso exista.  

## 🚀 Tecnologias Utilizadas  
- **Java 21**  
- **Spring Boot & Spring MVC**  
- **Thymeleaf**  
- **Jakarta Servlet (HttpSession)**  
- **JPA & Hibernate**  
- **Banco de Dados Oracle**

## ⚙️ Funcionalidades  
✅ **Persistência de dados no login** (via CPF)

✅ **Cadastro e consulta de pacientes** (via CPF)  

✅ **Registro de consultas** (anamnese e prescrição)  

✅ **Exibição do histórico médico** (anamnese e prescrição com formatação de data)

## 🛠️ Como Executar o Projeto  
1. **Clone o repositório:**  
```bash
   git clone https://github.com/sousa-sara/spring-mvc.git
```

2.  **Execute o projeto:**
```bash
mvn spring-boot:run
```
3. **Confirme a localização do projeto:**
http://localhost:8080/

4. **Login**:
Para acessar o sistema, é necessário utilizar um CPF já cadastrado no banco de dados. Utilize o seguinte CPF de exemplo:

📌 **CPF de teste**: 111.222.333-44

5. **Fluxo**:
Se o CPF do paciente já estiver cadastrado no sistema, será redirecionado diretamente para a página de Consulta Médica. Caso o CPF não seja encontrado na base de dados, o sistema encaminhará o usuário para a página de Cadastro de Novo Paciente. Após a conclusão do registro e seguindo as validações exigidas, será automaticamente direcionado para a Consulta Médica, permitindo a continuidade do atendimento. Após finalizado o atendimento, será direcionado para a página de login.

## 👥 Integrantes
- Leonardo Oliveira - RM554024

- Sara Sousa - RM552656



