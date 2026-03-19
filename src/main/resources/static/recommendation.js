// Step 1: Fetch recommendations from backend
async function getRecommendations(productName) {
    try {
        const response = await fetch(
            `http://localhost:8080/api/recommend?product=${encodeURIComponent(productName)}`
        );
        if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
        const data = await response.json();
        displayRecommendations(data);
    } catch (error) {
        console.error("Error fetching recommendations:", error);
        document.getElementById("recommendations").innerHTML =
            "<p>Unable to load recommendations.</p>";
    }
}

// Step 2: Display recommendations in the page
function displayRecommendations(products) {
    const container = document.getElementById("recommendations");
    if (!products || products.length === 0) {
        container.innerHTML = "<p>No recommendations available.</p>";
        return;
    }

    container.innerHTML = "<h3>You may also like</h3>";

    products.forEach(p => {
        const formattedPrice = "₹" + Number(p.price).toLocaleString("en-IN");
        container.innerHTML += `
            <div class="rec-card">
                <img src="${p.image}" width="150"/>
                <h4>${p.name}</h4>
                <p>${formattedPrice}</p>
            </div>
        `;
    });
}