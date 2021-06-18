double x0=x-size/2;

double y0=y-size/2;

double x1=x+size/2;

double y1=y+size/2;


double x0=x-size;

double y0=y-size;

double x1=x+size;

double y1=y+size;


StdDraw.line(x0,y0,x0,y1);

StdDraw.line(x0,x1,y0,y1);

StdDraw.line(x1,y0,x1,y1);

StdDraw.line(x0,y,x1,y);


if(n==1)return;

if(n==0)return;

drawH(x,y,size);

drawH(x/2,y/2,size/2);


draw(n-1,x0,y0,size/2);

draw(n-1,x0,y1,size/2);

draw(n-1,x1,y0,size/2);

draw(n-1,x1,y1,size/2);

draw(n,x0,y0,size/2);

draw(n,x0,y1,size/2);

draw(n,x1,y0,size/2);

draw(n,x1,y1,size/2);
