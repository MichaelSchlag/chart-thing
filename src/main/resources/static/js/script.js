var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");

drawChart();

function drawChart(){

    ctx.clearRect(0, 0, c.width, c.height);
    var lowX = document.getElementById("x-min").value;
    var highX = document.getElementById("x-max").value;
    var lowY = document.getElementById("y-min").value;
    var highY = document.getElementById("y-max").value;

    var diffX = highX - lowX;
    var diffY = highY - lowY;

    if(diffX < 0){
        diffX *= -1;
    }
    if(diffY < 0){
        diffY *= -1;
    }

    if(highX != lowX){
        var intervalX = c.width/(diffX);
    } else {
        var intervalX = c.width;
    }
    if(highY != lowY){
        var intervalY = c.height/(diffY);
    } else {
        var intervalY = c.height;
    }

    ctx.beginPath();

    for(var i = 1; i < diffX; i++){
        ctx.moveTo((intervalX * i),0);
        ctx.lineTo((intervalX * i),c.height);
        ctx.stroke();
    }

    for(var i = 1; i < diffY; i++){
        ctx.moveTo(0,(intervalY * i));
        ctx.lineTo(c.width,(intervalY * i));
        ctx.stroke();
    }
    ctx.stroke();

    var img = document.getElementById("apple");
    var itemX = document.getElementById("item-x").value;
    var itemY = document.getElementById("item-y").value;

//    if(itemX > highX){
//        itemX = highX;
//    }
//    if(itemX < lowX){
//        itemX = lowX;
//    }
//    if(itemY > highY){
//        itemY = highY;
//    }
//    if(itemY < lowY){
//        itemY = lowY;
//    }

//    itemX -= lowX;
//    itemY -= lowY;

    ctx.drawImage(img, ((itemX - lowX) * intervalX - img.width/2), ((itemY - lowY) * intervalY - img.height/2), img.width, img.height);

    document.getElementById("item-x").value = itemX;
    document.getElementById("item-y").value = itemY;
}

function showData(){
     document.getElementById("item-x").hidden = false;
     document.getElementById("item-y").hidden = false;

}