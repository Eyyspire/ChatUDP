# Rapport pour le TP2
- Tom Taffin
- Samuel Dubuisson

## Exercice 1
Voici ce qui a été envoyé et ce qui a été reçu par chaque programme : 

![Message envoyé par SendUDP](images/unicast_sender.png)  

Commande pour envoyer "Bonjour" à l'adresse de l'ordinateur a13p13 sur le port 1500 (après avoir compilé le TP avec `make cls`) :  
`java -classpath classes unicast.SendUDP a13p13 1500 "Bonjour"`  

![Message reçu par ReceiveUDP](images/unicast_receiver.png)  

Commande pour recevoir un message sur le port 1500 (après avoir compilé le TP avec `make cls`) :
`java -classpath classes unicast.ReceiveUDP 1500`  

## Exercice 2
Voici ce qui a été envoyé et ce qui a été reçu par chaque programme :

![Message envoyé par SendUDP](images/multicast_sender.png)  

Commande pour envoyer "Bonjour" à l'adresse multicast 224.0.0.1 sur le port 7654 (après avoir compilé le TP avec `make cls`) :  
`java -classpath classes multicast.SendUDP 224.0.0.1 7654 "Bonjour"`  

![Message reçu par ReceiveUDP (terminaux 1 et 2)](images/multicast_receiver.png)  

Commande pour recevoir les messages envoyées sur le multicast 224.0.0.1 sur le port 7654 (après avoir compilé le TP avec `make cls`) :  
`java -classpath classes multicast.ReceiveUDP 224.0.0.1 7654`  

## Exercice 3
Voici ce qui a été envoyé et ce qui a été reçu par chaque programme : 
 
![Chat géré par ChatUDP (terminal 1)](images/chat_chat1.png)  

![Chat géré par ChatUDP (terminal 2)](images/chat_chat2.png)  

Commande pour lancer un chat sur l'adresse 224.0.0.1 et le port 7654 (après avoir compilé le TP avec `make cls`) :  
`java -classpath classes chat.ChatUDP 224.0.0.1 7654`  
