<a name="readme-top"></a>

<!--
*** Template baseado em https://github.com/othneildrew/Best-README-Template 
-->

![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![[mysql]](https://img.shields.io/badge/Mysql-316192?style=for-the-badge&logo=mysql&logoColor=white)
![[kubernetes]](https://img.shields.io/badge/Kubernetes-3069DE?style=for-the-badge&logo=kubernetes&logoColor=white)




<br />
<div align="center">
  <h3 align="center">Tastytap - Users</h3>
  <img src="https://cdn.cisscloud.com.br/portal/pages/cisstotem/img/cisstotem2021.png" width="150px"/>
</div>

## Sobre o Projeto
Aplicação responsavel pelo gerenciamento de nosssos clientes.

Projeto atualizado para a quarta entrega da pós graduação em [Software Architecture da FIAP](https://postech.fiap.com.br/curso/software-architecture/).

Link do miro: https://miro.com/app/board/uXjVKTJ4mvk=/?share_link_id=556895060297

Link do desenho da arquitetura: https://drive.google.com/file/d/186D8N2BxR907FRHDmWTzllt5tJ4GfxJi/view?usp=drive_link

## Repositorios

**Link do repositorio da aplicação core:** https://github.com/gabrielronei/tastytap

**Link do repositorio do payments:** https://github.com/thaisandre/tastytap-payments

**Link do repositorio do terraform:** https://github.com/thaisandre/terraform-tastytap-infra

**Link do repositorio do database:** https://github.com/thaisandre/terraform-tastytap-database

**Link do repositorio do rds:** https://github.com/thaisandre/terraform-tastytap-rds

**Link do repositorio do terraform:** https://github.com/thaisandre/terraform-tastytap-infra

## Começando

Para executar o projeto em sua máquina siga os seguintes passos. 

### Pré-requisitos

* Docker com compose
  Veja a [documentação](https://docs.docker.com/engine/install/) para instalar o docker no seu sistema se ainda não tiver instalado.

### Instalação

A instalação é bem simples, siga as seguintes etapas:

1. Clone o repositório
   ```sh
   git clone https://github.com/gabrielronei/tastytap-users.git
   ```
2. Entre na pasta do projeto
   ```sh
   cd tastytap-users
   ```
3. Agora execute o projeto usando o docker compose
   ```sh
   docker compose up
   ```
4. Para acessar a documentação no swagger, acesse em seu navegador.
   ```
   http://localhost:8080/
   ```
## Kubernetes
Da para rodar localmente nossa arquitetura usando o minikube, siga os seguintes passos:
1. Inicie o minikube
   ```sh
   minikube start
   ```
2. Entre na pasta do kubernetes dentro do nosso projeto
   ```sh
   cd kubernetes/
   ```
3. Agora execute o script
   ```sh
   bash configure.sh
   ```
4. Só acessar a url com ip do cluster que foi mostrado na execução do script
   ```sh
   http://IP_DO_CLUSTER:30000/
   ```


## Exemplos de requests
Temos o arquivo <a href="https://github.com/gabrielronei/tastytap/blob/main/tastytap%20-%20fiap.postman_collection.json">tastytap-fiap.postman_collection.json</a> que pode ser importado no Postman ou em seu API Client de preferência(insomnia, testfully e etc), já estão estruturadas na ordem correta, ou caso prefira, pode seguir os exemplos abaixo:

<details>
  <summary>1. Criar usuário (opcionalmente): </summary>

  ```json
// GET /tastytap-users/user
{
  "name": "Saul Hudson",
  "email": "saul.hudson@gmail.com",
  "cpf": "285.977.970-10"
}
```
</details>

<details>
  <summary>2. Buscar usuário por CPF (opcionalmente): </summary>

  ```json
// GET /tastytap-users/user/285.977.970-10
```
</details>

## Cobertura de testes
![image](https://github.com/user-attachments/assets/ac7f42a3-28c8-40ed-9fa6-b97ebc7e009b)





<p align="right">(<a href="#readme-top">Voltar para o topo</a>)</p>
