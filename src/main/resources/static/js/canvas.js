var canvas = document.querySelector('canvas');

canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

var c = canvas.getContext('2d');

c.fillRect(1, 1, 300, 300);

c.beginPath();
c.moveTo(20, 0);
c.lineTo(20, 300);
c.stroke();