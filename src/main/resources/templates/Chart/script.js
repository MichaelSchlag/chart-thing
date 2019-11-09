var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
var lowX = 0;
var highX = 20;
var lowY = 0;
var highY = 20;
var intervalX = c.width/(highX-lowX);
var intervalY = c.height/(highY-lowY);
var itemX = 0;
var itemY = 0;

for(var i = 1; i < highX - lowX; i++){
    ctx.moveTo((intervalX * i),0);
    ctx.lineTo((intervalX * i),c.height);
    ctx.stroke();
}

for(var i = 1; i < highY - lowY; i++){
    ctx.moveTo(0,(intervalY * i));
    ctx.lineTo(c.width,(intervalY * i));
    ctx.stroke();
}