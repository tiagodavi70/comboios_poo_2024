from geopy.geocoders import Nominatim
# from geopy.geocoders import Nominatim

from geopy.exc import GeocoderTimedOut
import pandas as pd

geolocalizador = Nominatim(user_agent="comboios_kotlin_poo_2024")

def getCoords(end):
    try:
        localizacao = geolocalizador.geocode(end, language="pt", country_codes=["PT"])
        if localizacao:
            latitude = localizacao.latitude
            longitude = localizacao.longitude
            # print("Latitude:", latitude)
            # print("Longitude:", longitude)
            return [latitude,longitude]
        else:
            # print("Sem coordenadas")
            return [0,0]
    except GeocoderTimedOut:
        print("Geocoding time out.")

    except Exception as e:
        print("Erro:", e)

df = pd.read_csv("linha_vouga.csv")

# endereco = "Oliveira de Azémeis, Aveiro, Portugal"

# print(df.apply(getCoords))
df["coords"] = df["Lugar"].apply(lambda x: getCoords(f"{x}, Aveiro"))

df["latitude"] = [a[0] for a in df["coords"].values]
df["longitude"] = [a[1] for a in df["coords"].values]

df = df.drop("coords", axis=1)

df.to_csv("linha_vouga_completo.csv", index=False)

