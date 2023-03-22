
O código acima adiciona dois plugins ao build do Maven: o maven-compiler-plugin, que compila o código-fonte do projeto, e o maven-jar-plugin, que gera o arquivo JAR.

Abra o terminal ou prompt de comando e navegue até a pasta do projeto.
Execute o comando mvn clean package para limpar o diretório target e gerar o arquivo JAR do projeto.
O comando mvn clean package irá compilar o código-fonte do projeto e gerar um arquivo JAR na pasta target do projeto. O arquivo JAR será nomeado de acordo com o artifactId e a version definidos no arquivo pom.xml. Por exemplo, se o artifactId for meu-projeto e a version for 1.0-SNAPSHOT, o arquivo JAR será nomeado como meu-projeto-1.0-SNAPSHOT.jar.

Para executar o arquivo JAR, 

