# DesafioJava
Sistema de Gerenciamento de Cartas Colecionáveis modelo CRUD utilizando primefaces, jsf com persistência de dados utilizando mysql.

# Atividade Desenvolvida
Este sistema foi desenvolvido por Leonardo Nammur com o objetivo de apresentar uma aplicação web CRUD.
Aqui será possível guardar informações sobre quais cartas você possui para poder administrar melhor sua coleção,
podendo adicionar, salvar, remover e buscar as cartas. Na busca, pode-se ordenar por qualquer campo que desejar, contudo,
a busca sempre vai retornar todas as cartas.

# Como Usar
Quando estiver na página da aplicação, terá uma brevíssima descrição do sistema. Clicando em Gerenciar Cartas no menu superior, 
será redirecionado para uma outra página, na qual poderá manusear a lista de cartas.

## Funções dos Botões
* Novo: Será atualizada a tela e aparecerá os campos para preenchimento. Preencha todos e aperte em salvar.

* Salvar: Botão para confirmação da adição de uma nova carta ou modificação, se estiver sendo editada.

* Buscar: Atualiza a lista da tela com as cartas que estão no banco de dados cadastradas.

* Editar: Aparece ao lado dos registros. Clicando nele, será atualizada a tela com os dados atuais da carta para modificação dos
campos que desejar atualizar. Mantenha todos preenchidos (alterados ou não) e aperte em salvar.

* Deletar: Aparece ao lado dos registros. Clicando nele, deleta a carta selecionada.

# Tópicos da Avaliação Contemplados
Foram implementados os tópicos A,B e G.


# Instruções Para Execução
* Se não possuir o ambiente instalado baixe o jdk, netbeans, apache tomcat e o mysql workbench e instale-os.

* Abra o workbench, e abra o schema "desafioJavaModel" da pasta models do projeto. Depois crie uma conexão localhost.

* Ainda no workbench, va em synchronize model with database, na aba de menu do database. Conecte na localhost, vá avançando até que possa marcar
o schema sistema-cartas. Marque-o.

* No netbeans, depois de abrir o projeto (certifique-se de ter os plug-ins jsf e primefaces no seu netbeans, se não tiver, va no menu superior,
ferramentas, plug-ins e instale-os) vá em ferramentas, servidores, adicionar servidor e selecione o apache tomcat com localhost como localização do servidor.

* Mude no arquivo util/FabricaConexao.java o seu link para o banco de dados, usuário e senha do banco de dados nas linhas 15, 16 e 17 respectivamente

* Se mudar o nome da tabela, precisará mudar em CartaDAO nos PreparedStatement dentro das strings para o nome de sua tabela atual.

* Pressione F6 ou clique no triangulo verde para executar. Seu navegador irá abrir na página da aplicação.

Se tiver restado alguma duvida ou tiver algum erro, entre em contato pelo e-mail leonammur@gmail.com.
