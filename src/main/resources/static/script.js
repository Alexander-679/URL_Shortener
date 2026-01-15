function shortenUrl() {
    const longUrl = document.getElementById("urlInput").value;

    if (!longUrl) {
        alert("Please enter a URL");
        return;
    }

    fetch("/api/shorten", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ url: longUrl })
    })
    .then(res => res.json())
    .then(data => {
        const shortUrl = `http://localhost:8080/r/${data.shortCode}`;

        document.getElementById("shortUrl").value = shortUrl;
        document.getElementById("resultBox").classList.remove("hidden");
    })
    .catch(() => alert("Something went wrong"));
}

function copyUrl() {
    const shortUrlInput = document.getElementById("shortUrl");
    shortUrlInput.select();
    document.execCommand("copy");
    alert("Short URL copied!");
}
