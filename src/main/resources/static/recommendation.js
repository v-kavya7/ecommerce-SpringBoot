console.log("Recommendation JS loaded");
function loadRecommendations(productName) {

    console.log("Calling recommendation API...");

    fetch("http://localhost:8080/products/recommendations?product=" + productName)
    .then(res => res.json())
    .then(data => {

        console.log("Recommendations:", data);

        let container = document.getElementById("recommendations");

        if(!container) return;

        container.innerHTML = "";

        data.forEach(p => {
            let div = document.createElement("div");
            div.innerText = p;
            container.appendChild(div);
        });

    });
}