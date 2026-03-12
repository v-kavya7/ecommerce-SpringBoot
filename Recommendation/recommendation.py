import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity

data = pd.read_csv("products.csv")

data["tags"] = data["name"] + " " + data["description"]

cv = CountVectorizer(stop_words="english")
vectors = cv.fit_transform(data["tags"]).toarray()

similarity = cosine_similarity(vectors)

def recommend(product_name):

    index = data[data["name"] == product_name].index[0]

    distances = similarity[index]

    products = list(enumerate(distances))

    products = sorted(products, key=lambda x: x[1], reverse=True)[1:4]

    recommended = []

    for i in products:
        recommended.append(data.iloc[i[0]].name)

    return recommended