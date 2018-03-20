const xhr = new XMLHttpRequest();

xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText);
		const tagList = document.querySelector('.tagList')
		
		for (tag in res){
			const tagList = document.createElement('div')
			const tagLink = document.createElement('a')
			tagLink.setAttribute('href', '/templates/tagView.html');
			tagLink.innerText = res[tag].name
			tagList.appendChild(tagLink)
		}
	}
}

	xhr.open('GET', 'http://localhost:8080/review?id=1', true);
	xhr.send();
	
	
