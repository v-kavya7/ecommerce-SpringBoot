from flask import Flask, request, jsonify
from recommendation import recommend

app = Flask(__name__)

@app.route('/recommend')

def get_recommendations():

    product = request.args.get("product")

    result = recommend(product)

    return jsonify(result)

if __name__ == "__main__":
    app.run(port=5000)