var listItems = document.querySelectorAll('ul li a');
listItems.forEach(function(list){
list.addEventListener('mouseover', function(){
	list.style.fontSize = '20px';
		})
});

var listItems = document.querySelectorAll('ul li a');
listItems.forEach(function(list){
list.addEventListener('mouseout', function(){
	list.style.fontSize	= '15px';
		})
});
