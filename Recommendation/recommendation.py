import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity

data = pd.read_csv("products.csv", engine='python', on_bad_lines='skip')

data["tags"] = data["name"] + " " + data["description"]

cv = CountVectorizer(stop_words="english")
vectors = cv.fit_transform(data["tags"]).toarray()

similarity = cosine_similarity(vectors)

def recommend(product_name):

    # Debug print (important)
    print("Received product:", product_name)

    # Clean input (avoid case issues)
    product_name = product_name.strip()

    # Check if product exists
    if product_name not in data["name"].values:
        return ["No recommendations found"]

    index = data[data["name"] == product_name].index[0]

    distances = similarity[index]
    products = list(enumerate(distances))
    products = sorted(products, key=lambda x: x[1], reverse=True)[1:4]

    recommended = []

    for i in products:
        recommended.append({
            "name": data.iloc[i[0]]["name"],
            "price": int(data.iloc[i[0]]["price"]),
            "image": data.iloc[i[0]]["image_url"]
        })

    return recommended