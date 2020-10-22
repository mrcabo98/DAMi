# Author : Marc Cabo Dieguez
# Date : 22/10/2021
# Ejercici 4 - Obtenir el Nom, Sexe i Edat dels 5 primers passatgers

import pandas as pd

titanic = pd.read_csv("titanic.csv")

# Mostrem únicament aquestes 3 columnes
name_sex_age = titanic[["Name", "Sex", "Age"]]

# Printem el 5 primers passatger amb les 3 columnes específiques
print(name_sex_age.head(5))
