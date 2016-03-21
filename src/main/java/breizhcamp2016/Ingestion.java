package breizhcamp2016;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class Ingestion {

    public static String[] titles = {
            "Challenge Mindstorms - Tester votre capacité à développer",
            "Guide de survie du développeur perdu dans une application qui rame",
            "Xtreme Refactoring Deathmatch",
            "Guide de survie en milieu caractèriel",
            "Mais qu'est-ce que je fous ?",
            "Docker Birthday #3 Celebration + Training",
            "Apache Zeppelin, un notebook d'avenir pour l'éco-système Big Data",
            "Développer une application mobile avec Ionic",
            "Let's React : le lab !",
            "Tout ce que le getting started MongoDB ne vous dira pas",
            "Lambda architecture en pratique avec Spark et Cassandra",
            "Sécurité Frontend",
            "Les fausses bonnes idées que j’ai croisé dans ma carrière",
            " devoxx4kids",
            "100% Stateless avec JWT (JSON Web Token)",
            "L'atout du Golang : Concurrence, Parallélisme et goroutine",
            "Angular 2 Getting Started",
            "Docker en Production ? Et quid de la sécurité ?",
            "Warp10 - Collectez, stoquez et analysez vos Séries Temporelles #JustOpenSourced",
            "Sass, pratique tout de suite",
            "Une plateforme de continuous delivery en 45 minutes",
            "RabbitMQ 101 : job scheduling, micro service communication, event based data stream… How to cook the rabbit?",
            "Une base de données polymorphes",
            "Les requêtes HTTP de l'extrême",
            "Développer un Web Service Géospatial avec Kotlin et Spring Boot",
            "Aurelia and the space cows",
            "Applications \"cloud-native\" avec Spring Cloud",
            "Mob programming, Promesses tenues ?",
            "Docker pour développeurs : 5 conteneurs pour 5 langages",
            "Déploiement ELK en conditions réelles",
            "Flexbox, et le CSS redevient fun !",
            "Lego, Tagada, Data et Arduino : projet gourmand au StartupWeekEnd Brest",
            "Vers un Web HTTPS avec Let's Encrypt",
            "Traefik, a modern reverse-proxy",
            "Ionic, Native Script, React native... Quel framework mobile hybride choisir?",
            "Suivi des vulnérabilités dans les dépendances",
            "DevOps sur Android : D'un git push à une release sur le Play Store",
            "Codons une pompe à Bière connectée sur Arduino Yùn"
    };

    public static String[] desc = {
            "Ooooh la belle description", "Pourquoi faire une description", "Voilà voilà...", null
    };

    public static String[] speakers = {
//            "Tintin", "Milou", "Capitaine Haddock", "Professeur Tournesol", "La Castatiore", "Seraphin Lampion",
//            "Dupont", "Dupond"
            "Jean-Michel", "Jean-Paul", "Jean-Marcel", "Jean-Roger", "Jean-Benoît", "Jean-Jean", "Jean-Pierre", "Jean-Stanislas",
            "Jean-Olivier", "Jean-Frédéric", "Jean-Alexandre", "Jean-Jérôme"

    };

    public static void main(String[] args) {

        MongoClient client = new MongoClient("192.168.100.133:28100");

        Morphia morphia = new Morphia();
        morphia.map(Conference.class, Speaker.class);

        Datastore datastore = morphia.createDatastore(client, "breizhcamp2016");
        datastore.delete(datastore.createQuery(Conference.class));
        datastore.delete(datastore.createQuery(Speaker.class));

        List<Speaker> theSpeakers = new ArrayList<>();
        for (String speaker : speakers) {
            Speaker aSpeaker = new Speaker(speaker);
            theSpeakers.add(aSpeaker);
            datastore.save(aSpeaker);
        }

        for (String title : titles) {
            Conference conf = new Conference(title, Arrays.asList(
                    theSpeakers.get((int)Math.floor(Math.random() * speakers.length)).twitterHandle,
                  theSpeakers.get((int)Math.floor(Math.random() * speakers.length)).twitterHandle));
//            Conference conf = new Conference(title, desc[(int)Math.floor(Math.random() * desc.length)],
////                    speakers[(int)Math.floor(Math.random() * speakers.length)]);
//                    theSpeakers.get((int)Math.floor(Math.random() * speakers.length)).twitterHandle,
//                    theSpeakers.get((int)Math.floor(Math.random() * speakers.length)).twitterHandle);
            datastore.save(conf);
        }


    }

}
