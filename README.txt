Eric Thai a fait les questions Spark
Lucas Bevilacqua a fait les questions 2.7 et 2.8
Simon Bouresche a fait les questions 5.1 et 5.3

Pour exécuter 2.7: (fonctionne sous Windows dans la machine virtuelle Cloudera)
placer arbres.csv dans hdfs
se positionner dans le dossier Question2-7
lancer la commande :
java -cp "bin:`hadoop classpath`" cs.bigdata.Tutorial2.Main [chemin de arbres.csv dans hdfs (ex : /user/cloudera/arbres.csv)]

Pour exécuter 2.8: (fonctionne sous Windows dans la machine virtuelle Cloudera)
placer isd-history.txt dans hdfs
se positionner dans le dossier Question2-8
lancer la commande :
java -cp "bin:`hadoop classpath`" cs.bigdata.Tutorial2.Main [chemin de isd-history.txt dans hdfs (ex : /user/cloudera/isd-history.txt)]
