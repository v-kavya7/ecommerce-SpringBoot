from flask import Flask, request, jsonify
from recommendation import recommend

app = Flask(__name__)

@app.route('/recommend', methods=['GET'])
def get_recommendations():
    try:
        product = request.args.get("product")

        if not product:
            return jsonify({"error": "Product parameter missing"}), 400

        result = recommend(product)

        return jsonify(result)

    except Exception as e:
        print("ERROR:", e)   # prints error in terminal
        return jsonify({"error": str(e)}), 500


if __name__ == "__main__":
    app.run(debug=True, port=5000)