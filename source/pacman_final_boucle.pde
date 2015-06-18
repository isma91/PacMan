import ddf.minim.*;
import ddf.minim.signals.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
int compteur,Depart,etape,etapedifi;
int a=4;//musique de départ
int pacSize = 25; /* taille pacman*/
int direction = -1; 
int direction2 = 0;
int xdep,ydep,xcase,ycase,taillePC,xRouge,yRouge,xRose,yRose,xOrange,yOrange,xBleue,yBleue,xVert,yVert,xBlanc,yBlanc,xFantome,yFantome;
int x = 10;
int y = 10;
int [][]tab=new int[20][20];
float speed = 40; /*vitesse pacman*/
boolean halt = true;// pacman bouge pas 
Minim minim;
AudioPlayer song;
  
  void setup(){
   
  size(800,880);
  background(0,0,0);
  musique();
  x = 380;
  y = 340;
 
 tab = carte();
 
  frameRate(10);//vitesse jeu//

  taillePC=25;
  xRouge=730;
  yRouge=90;
  xRose=50;
  yRose=90;
  xOrange=50;
  yOrange=770;
  xBleue=730;
  yBleue=770;
  xVert=370;
  yVert=90; 
  xBlanc=370;
  yBlanc=770;
  Depart=0;
  etape=0;
  etapedifi=0;
  compteur=0;
  PFont police; 
  police=loadFont ("Amethyst-48.vlw");
  textFont(police);
  
  }
  
  void draw(){
  background(0,0,0);
  text("Pac man creation 2013 by ismail and jordan ",110,280);
  text("amusez-vous :) ",300,320);
  text("pour changer de musique appuyer soit sur a,z,e,r,t,y",90,650);
  
    PImage logo;
  logo =loadImage("logo.gif");
  image(logo,160,10);
  
      PImage pacoo;
  pacoo =loadImage("pacoo.gif");
  image(pacoo,300,350);
  
  if(keyPressed==true){
    if(key=='a'){
      song.close();
    a=2;
    musique();
  }
  
  if(key=='z'){
    song.close();
    a=1;
    musique();
  }
   if(key=='e'){
    song.close();
    a=4;
    musique();
  }
   if(key=='r'){
    song.close();
    a=3;
    musique();
  }
   if(key=='t'){
      song.close();
    a=5;
    musique();
  }
  if(key=='y'){
      song.close();
    a=6;
    musique();
  }
   }
  
  
  
  
   if(etape==0){
    fill(0,0,255);
     if(mouseY > 300 && mouseY < 400){ // si souris passe sur case 1joueur change couleur fond rectangle et texte
         fill(0,255,0); //FOND RECTANGLE
         rect(200,330,400,50);
         fill(255,255,255);//couleur texte
         textSize(30);
         text("1 joueur",340,367);
         if (mouseButton == LEFT) etape=1; 
        
     }  
       else{// si la souris ne passe pas sur la case 1joueur
         fill(255,255,255);
         rect(200,330,400,50);
         fill(0,0,0);
         textSize(30);
         text("1 joueur",340,367);
           }
      if(mouseY > 400 && mouseY < 500){
         fill(0,255,0);
         rect(200,450,400,50);
         fill(255,255,255);
         textSize(30);
         text("pour ouvir clic droit",210,485);
         if (mouseButton == RIGHT) etape=2; 
      }
         else{
         fill(255,255,255);
         rect(200,450,400,50);
         fill(0,0,0);
         textSize(30);
         text("difficulté",336,485);
      }
      if(mouseY > 500 && mouseY < 600){
         fill(0,255,0);
         rect(200,555,400,50);
         fill(255,255,255);
         textSize(30);
         text("quitter",340,589);
         if (mouseButton == LEFT) etape=3;
      }
         else{
         fill(255,255,255);
         rect(200,555,400,50);
         fill(0,0,0);
         textSize(30);
         text("quitter",340,589);
             }
  }    
    
  if(etape==1){
  xdep=x;
  ydep=y;
  xcase=x/40;
  ycase=y/40;
    
    //Boucle Fantôme Rose
      if(yRose==90){
        if(xRose<=210){
          xRose=xRose+40;}
      }
      
      if(xRose==250){
        if(yRose<=130){
          yRose=yRose+40;}
      }
      
      if(yRose==170){
        if(xRose>=210){
          xRose=xRose-40;}
      }
      
      if(xRose==170){
        if(yRose<=330 && yRose>=170){
          yRose=yRose+40;}
      }
      
      if(yRose==370){
        if(xRose>=130){
          xRose=xRose-40;}
      }
      
      if(xRose==90){
        if(yRose<=370 && yRose>=330){
          yRose=yRose-40;}
      }
      
      if(xRose==90 && yRose==290){
        xRose=xRose-40;}
      
      if(xRose==50){
        if(yRose<=290 && yRose>=130){
          yRose=yRose-40;}
      }  
      
      
      //Boucle Fantôme Rouge
      if(xRouge>=730){
        if(yRouge<=250){
          yRouge=yRouge+40;}
      }
      
      if(xRouge==730 && yRouge==290){
        xRouge=xRouge-40;}
        
      if(xRouge==690){
        if(yRouge>=290 && yRouge<=340){
          yRouge=yRouge+40;}
      }
      
      if(yRouge==370){
        if(xRouge>=650){
          xRouge=xRouge-40;}
      }
      
      if(xRouge==610){
        if(yRouge>=210){
          yRouge=yRouge-40;}
      }
      
      if(yRouge==170){
         if(xRouge<=610 && xRouge>=570){
            xRouge=xRouge-40;}
      }

      if(xRouge==530){
        if(yRouge<=170 && yRouge>=130){
          yRouge=yRouge-40;}
      }

      if(yRouge==90){
        if(xRouge>=530 && xRouge<=690){
          xRouge=xRouge+40;}
      }
      
      
      //Boucle Fantôme Orange
      if(yOrange==770){
         if(xOrange<=290){
           xOrange=xOrange+40;}
      }
      
      if(xOrange==330){
        if(yOrange>=730){
          yOrange=yOrange-40;}
      }
      
      if(yOrange==690){
        if(xOrange>=210){
          xOrange=xOrange-40;}
      }
      
      if(xOrange==170){
        if(yOrange>=530 && yOrange<=690){
          yOrange=yOrange-40;}
      }
      
      if(yOrange==490){
        if(xOrange>=130){
          xOrange=xOrange-40;}
      }
      
      if(xOrange==90){
        if(yOrange>=490 && yOrange<=570){
          yOrange=yOrange+40;}
      }
      
      if(xOrange==90 && yOrange==610){
        xOrange=xOrange-40;}
      
      if(xOrange==50){
        if(yOrange>=610 && yOrange<=730){
          yOrange=yOrange+40;}
      }
      
      
      //Boucle Bleue
      if(yBleue==770){
        if(xBleue>=490){
          xBleue=xBleue-40;}
      }
      
      if(xBleue==450){
        if(yBleue>=730){
          yBleue=yBleue-40;}
      }
      
      if(yBleue==690){
        if(xBleue<=570 && xBleue>=450){
          xBleue=xBleue+40;}
      }
      
      if(xBleue==610){
        if(yBleue>=530 && yBleue<=690){
          yBleue=yBleue-40;}
      }
      
      if(yBleue==490){
        if(xBleue<=650){
          xBleue=xBleue+40;}
      }
      
      if(xBleue==690){
        if(yBleue<=570 && yBleue>=490){
          yBleue=yBleue+40;}
      }
      
      if(xBleue==690 && yBleue==610){
        xBleue=xBleue+40;}
        
      if(xBleue==730){
        if(yBleue<=730){
          yBleue=yBleue+40;}
      }
      
   simulate();  

   if(direction==1 ){//droite
     if (tab[ycase][(xcase+1)%20]==1){ //le xcase+1 definie la case qui suit
     x=xdep;
     y=ydep;
 }
   }
   if(direction==-1 ){//gauche
   if (tab[ycase][(xcase-1)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
 if(direction2 == -1){//haut
   if (tab[ycase-1][(xcase)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
   
   if(direction2 == 1  ){//bas
   if (tab[ycase+1][(xcase)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
   render();
  }
  
  
  
    if(etape==2){
     if(mouseY > 300 && mouseY < 400){ // si souris passe sur case 1joueur change couleur fond rectangle et texte
         fill(0,255,0); //FOND RECTANGLE
         rect(200,350,400,50);;
         fill(255,255,255);//couleur texte
         textSize(30);
         text("facile",340,385);
         if (mouseButton == LEFT) etapedifi=4; 
     }  
       else{// si la souris ne passe pas sur la case 1joueur
         fill(255,255,255);
         rect(200,350,400,50);
         fill(0,0,0);
         textSize(30);
         text("facile",340,385);
           }
      if(mouseY > 400 && mouseY < 500){
         fill(0,255,0);
         rect(200,450,400,50);
         fill(255,255,255);
         textSize(30);
         text("moyen",336,485);
         if (mouseButton == LEFT) etapedifi=5; 
      }
         else{
         fill(255,255,255);
         rect(200,450,400,50);
         fill(0,0,0);
         textSize(30);
          text("moyen",336,485);
      }
      if(mouseY > 500 && mouseY < 600){
         fill(0,255,0);
         rect(200,555,400,50);
         fill(255,255,255);
         textSize(30);
         text("difficile",340,589);
         if (mouseButton == LEFT) etapedifi=6;
      }
         else{
         fill(255,255,255);
         rect(200,555,400,50);
         fill(0,0,0);
         textSize(30);
         text("difficile",340,589);
             }
  }  
  strokeWeight(10);// epaisseur contour
  stroke(0, 255, 0);//couleur contour
  noFill();
  rect(0,0,width-1,height-1);//rectangle contour

  
  fill(0,255,0);//couleur texte
  stroke(0,0,0);// couleur contour de la balle et contour menu
  strokeWeight(2.5);//epaisseur contour de la balle et contour menu


 if(etapedifi==4){//Facile
   xdep=x;
  ydep=y;
  xcase=x/40;
  ycase=y/40;
  
  //Boucle Fantôme Rose
      if(yRose==90){
        if(xRose<=210){
          xRose=xRose+40;}
      }
      
      if(xRose==250){
        if(yRose<=130){
          yRose=yRose+40;}
      }
      
      if(yRose==170){
        if(xRose>=210){
          xRose=xRose-40;}
      }
      
      if(xRose==170){
        if(yRose<=330 && yRose>=170){
          yRose=yRose+40;}
      }
      
      if(yRose==370){
        if(xRose>=130){
          xRose=xRose-40;}
      }
      
      if(xRose==90){
        if(yRose<=370 && yRose>=330){
          yRose=yRose-40;}
      }
      
      if(xRose==90 && yRose==290){
        xRose=xRose-40;}
      
      if(xRose==50){
        if(yRose<=290 && yRose>=130){
          yRose=yRose-40;}
      }  
      
      
      //Boucle Fantôme Rouge
      if(xRouge>=730){
        if(yRouge<=250){
          yRouge=yRouge+40;}
      }
      
      if(xRouge==730 && yRouge==290){
        xRouge=xRouge-40;}
        
      if(xRouge==690){
        if(yRouge>=290 && yRouge<=340){
          yRouge=yRouge+40;}
      }
      
      if(yRouge==370){
        if(xRouge>=650){
          xRouge=xRouge-40;}
      }
      
      if(xRouge==610){
        if(yRouge>=210){
          yRouge=yRouge-40;}
      }
      
      if(yRouge==170){
         if(xRouge<=610 && xRouge>=570){
            xRouge=xRouge-40;}
      }

      if(xRouge==530){
        if(yRouge<=170 && yRouge>=130){
          yRouge=yRouge-40;}
      }

      if(yRouge==90){
        if(xRouge>=530 && xRouge<=690){
          xRouge=xRouge+40;}
      }
      
      
      //Boucle Fantôme Orange
      if(yOrange==770){
         if(xOrange<=290){
           xOrange=xOrange+40;}
      }
      
      if(xOrange==330){
        if(yOrange>=730){
          yOrange=yOrange-40;}
      }
      
      if(yOrange==690){
        if(xOrange>=210){
          xOrange=xOrange-40;}
      }
      
      if(xOrange==170){
        if(yOrange>=530 && yOrange<=690){
          yOrange=yOrange-40;}
      }
      
      if(yOrange==490){
        if(xOrange>=130){
          xOrange=xOrange-40;}
      }
      
      if(xOrange==90){
        if(yOrange>=490 && yOrange<=570){
          yOrange=yOrange+40;}
      }
      
      if(xOrange==90 && yOrange==610){
        xOrange=xOrange-40;}
      
      if(xOrange==50){
        if(yOrange>=610 && yOrange<=730){
          yOrange=yOrange+40;}
      }
      
      
      //Boucle Bleue
      if(yBleue==770){
        if(xBleue>=490){
          xBleue=xBleue-40;}
      }
      
      if(xBleue==450){
        if(yBleue>=730){
          yBleue=yBleue-40;}
      }
      
      if(yBleue==690){
        if(xBleue<=570 && xBleue>=450){
          xBleue=xBleue+40;}
      }
      
      if(xBleue==610){
        if(yBleue>=530 && yBleue<=690){
          yBleue=yBleue-40;}
      }
      
      if(yBleue==490){
        if(xBleue<=650){
          xBleue=xBleue+40;}
      }
      
      if(xBleue==690){
        if(yBleue<=570 && yBleue>=490){
          yBleue=yBleue+40;}
      }
      
      if(xBleue==690 && yBleue==610){
        xBleue=xBleue+40;}
        
      if(xBleue==730){
        if(yBleue<=730){
          yBleue=yBleue+40;}
      }
   simulate();
   if(direction==1 ){//droite
     if (tab[ycase][(xcase+1)%20]==1){ //le xcase+1 definie la case qui suit le %20 permet d'avoir 20 cases et donc que lorsque le pacman rencontre la case 20 celle qui suit n'est pas 21 mais 1 car 21 n'existe pas
     x=xdep;
     y=ydep;
 }
   }
   if(direction==-1 ){//gauche
   if (tab[ycase][(xcase-1)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
 if(direction2 == -1){//haut
   if (tab[ycase-1][(xcase)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
   
   if(direction2 == 1  ){//bas
   if (tab[ycase+1][(xcase)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
 render();
  }

 if(etapedifi==5){//Moyen
   xdep=x;
  ydep=y;
  xcase=x/40;
  ycase=y/40;
  
  //Boucle Fantôme Rose
      if(yRose==90){
        if(xRose<=210){
          xRose=xRose+40;}
      }
      
      if(xRose==250){
        if(yRose<=130){
          yRose=yRose+40;}
      }
      
      if(yRose==170){
        if(xRose>=210){
          xRose=xRose-40;}
      }
      
      if(xRose==170){
        if(yRose<=330 && yRose>=170){
          yRose=yRose+40;}
      }
      
      if(yRose==370){
        if(xRose>=130){
          xRose=xRose-40;}
      }
      
      if(xRose==90){
        if(yRose<=370 && yRose>=330){
          yRose=yRose-40;}
      }
      
      if(xRose==90 && yRose==290){
        xRose=xRose-40;}
      
      if(xRose==50){
        if(yRose<=290 && yRose>=130){
          yRose=yRose-40;}
      }  
      
      
      //Boucle Fantôme Rouge
      if(xRouge>=730){
        if(yRouge<=250){
          yRouge=yRouge+40;}
      }
      
      if(xRouge==730 && yRouge==290){
        xRouge=xRouge-40;}
        
      if(xRouge==690){
        if(yRouge>=290 && yRouge<=340){
          yRouge=yRouge+40;}
      }
      
      if(yRouge==370){
        if(xRouge>=650){
          xRouge=xRouge-40;}
      }
      
      if(xRouge==610){
        if(yRouge>=210){
          yRouge=yRouge-40;}
      }
      
      if(yRouge==170){
         if(xRouge<=610 && xRouge>=570){
            xRouge=xRouge-40;}
      }

      if(xRouge==530){
        if(yRouge<=170 && yRouge>=130){
          yRouge=yRouge-40;}
      }

      if(yRouge==90){
        if(xRouge>=530 && xRouge<=690){
          xRouge=xRouge+40;}
      }
      
      
      //Boucle Fantôme Orange
      if(yOrange==770){
         if(xOrange<=290){
           xOrange=xOrange+40;}
      }
      
      if(xOrange==330){
        if(yOrange>=730){
          yOrange=yOrange-40;}
      }
      
      if(yOrange==690){
        if(xOrange>=210){
          xOrange=xOrange-40;}
      }
      
      if(xOrange==170){
        if(yOrange>=530 && yOrange<=690){
          yOrange=yOrange-40;}
      }
      
      if(yOrange==490){
        if(xOrange>=130){
          xOrange=xOrange-40;}
      }
      
      if(xOrange==90){
        if(yOrange>=490 && yOrange<=570){
          yOrange=yOrange+40;}
      }
      
      if(xOrange==90 && yOrange==610){
        xOrange=xOrange-40;}
      
      if(xOrange==50){
        if(yOrange>=610 && yOrange<=730){
          yOrange=yOrange+40;}
      }
      
      
      //Boucle Bleue
      if(yBleue==770){
        if(xBleue>=490){
          xBleue=xBleue-40;}
      }
      
      if(xBleue==450){
        if(yBleue>=730){
          yBleue=yBleue-40;}
      }
      
      if(yBleue==690){
        if(xBleue<=570 && xBleue>=450){
          xBleue=xBleue+40;}
      }
      
      if(xBleue==610){
        if(yBleue>=530 && yBleue<=690){
          yBleue=yBleue-40;}
      }
      
      if(yBleue==490){
        if(xBleue<=650){
          xBleue=xBleue+40;}
      }
      
      if(xBleue==690){
        if(yBleue<=570 && yBleue>=490){
          yBleue=yBleue+40;}
      }
      
      if(xBleue==690 && yBleue==610){
        xBleue=xBleue+40;}
        
      if(xBleue==730){
        if(yBleue<=730){
          yBleue=yBleue+40;}
      }
      
      
      //Boucle Vert
      if(yVert==90){
        if(xVert>=270 && xVert<=370){
          xVert=xVert-40;}
      }
      
      if(xVert==250){
        if(yVert<=130){
          yVert=yVert+40;}
      }
      
      if(yVert==170){
        if(xVert<=490){
          xVert=xVert+40;}
      }
      
      if(xVert==530){
        if(yVert>=130){
          yVert=yVert-40;}
      }
      
      if(yVert==90){
         if(xVert<=530 && xVert>=410){
           xVert=xVert-40;}
      }
   simulate();
   if(direction==1 ){//droite
     if (tab[ycase][(xcase+1)%20]==1){ //le xcase+1 definie la case qui suit
     x=xdep;
     y=ydep;
 }
   }
   if(direction==-1 ){//gauche
   if (tab[ycase][(xcase-1)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
 if(direction2 == -1){//haut
   if (tab[ycase-1][(xcase)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
   
   if(direction2 == 1  ){//bas
   if (tab[ycase+1][(xcase)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
 renderMoyen();
  }


  if(etapedifi==6){//Difficile
 xdep=x;
  ydep=y;
  xcase=x/40;
  ycase=y/40;
  
  //Boucle Fantôme Rose
      if(yRose==90){
        if(xRose<=210){
          xRose=xRose+40;}
      }
      
      if(xRose==250){
        if(yRose<=130){
          yRose=yRose+40;}
      }
      
      if(yRose==170){
        if(xRose>=210){
          xRose=xRose-40;}
      }
      
      if(xRose==170){
        if(yRose<=330 && yRose>=170){
          yRose=yRose+40;}
      }
      
      if(yRose==370){
        if(xRose>=130){
          xRose=xRose-40;}
      }
      
      if(xRose==90){
        if(yRose<=370 && yRose>=330){
          yRose=yRose-40;}
      }
      
      if(xRose==90 && yRose==290){
        xRose=xRose-40;}
      
      if(xRose==50){
        if(yRose<=290 && yRose>=130){
          yRose=yRose-40;}
      }  
      
      
      //Boucle Fantôme Rouge
      if(xRouge>=730){
        if(yRouge<=250){
          yRouge=yRouge+40;}
      }
      
      if(xRouge==730 && yRouge==290){
        xRouge=xRouge-40;}
        
      if(xRouge==690){
        if(yRouge>=290 && yRouge<=340){
          yRouge=yRouge+40;}
      }
      
      if(yRouge==370){
        if(xRouge>=650){
          xRouge=xRouge-40;}
      }
      
      if(xRouge==610){
        if(yRouge>=210){
          yRouge=yRouge-40;}
      }
      
      if(yRouge==170){
         if(xRouge<=610 && xRouge>=570){
            xRouge=xRouge-40;}
      }

      if(xRouge==530){
        if(yRouge<=170 && yRouge>=130){
          yRouge=yRouge-40;}
      }

      if(yRouge==90){
        if(xRouge>=530 && xRouge<=690){
          xRouge=xRouge+40;}
      }
      
      
      //Boucle Fantôme Orange
      if(yOrange==770){
         if(xOrange<=290){
           xOrange=xOrange+40;}
      }
      
      if(xOrange==330){
        if(yOrange>=730){
          yOrange=yOrange-40;}
      }
      
      if(yOrange==690){
        if(xOrange>=210){
          xOrange=xOrange-40;}
      }
      
      if(xOrange==170){
        if(yOrange>=530 && yOrange<=690){
          yOrange=yOrange-40;}
      }
      
      if(yOrange==490){
        if(xOrange>=130){
          xOrange=xOrange-40;}
      }
      
      if(xOrange==90){
        if(yOrange>=490 && yOrange<=570){
          yOrange=yOrange+40;}
      }
      
      if(xOrange==90 && yOrange==610){
        xOrange=xOrange-40;}
      
      if(xOrange==50){
        if(yOrange>=610 && yOrange<=730){
          yOrange=yOrange+40;}
      }
      
      
      //Boucle Bleue
      if(yBleue==770){
        if(xBleue>=490){
          xBleue=xBleue-40;}
      }
      
      if(xBleue==450){
        if(yBleue>=730){
          yBleue=yBleue-40;}
      }
      
      if(yBleue==690){
        if(xBleue<=570 && xBleue>=450){
          xBleue=xBleue+40;}
      }
      
      if(xBleue==610){
        if(yBleue>=530 && yBleue<=690){
          yBleue=yBleue-40;}
      }
      
      if(yBleue==490){
        if(xBleue<=650){
          xBleue=xBleue+40;}
      }
      
      if(xBleue==690){
        if(yBleue<=570 && yBleue>=490){
          yBleue=yBleue+40;}
      }
      
      if(xBleue==690 && yBleue==610){
        xBleue=xBleue+40;}
        
      if(xBleue==730){
        if(yBleue<=730){
          yBleue=yBleue+40;}
      }
        
        
      //Boucle Vert
      if(yVert==90){
        if(xVert>=270 && xVert<=370){
          xVert=xVert-40;}
      }
      
      if(xVert==250){
        if(yVert<=130){
          yVert=yVert+40;}
      }
      
      if(yVert==170){
        if(xVert<=490){
          xVert=xVert+40;}
      }
      
      if(xVert==530){
        if(yVert>=130){
          yVert=yVert-40;}
      }
      
      if(yVert==90){
         if(xVert<=530 && xVert>=410){
           xVert=xVert-40;}
      }
       
       
       //Boucle Blanc
       if(yBlanc==770){
         if(xBlanc<=410){
           xBlanc=xBlanc+40;}
       }
       
       if(xBlanc==450){
         if(yBlanc>=730){
           yBlanc=yBlanc-40;}
       }
       
       if(yBlanc==690){
         if(xBlanc<=490 && xBlanc>=450){
           xBlanc=xBlanc+40;}
       }
       
       if(xBlanc==530){
         if(yBlanc>=650){
           yBlanc=yBlanc-40;}
       }
       
       if(yBlanc==610){
         if(xBlanc>=290){
           xBlanc=xBlanc-40;}
       }
       
       if(xBlanc==250){
         if(yBlanc<=650){
           yBlanc=yBlanc+40;}
       }
       
       if(yBlanc==690){
         if(xBlanc<=290){
           xBlanc=xBlanc+40;}
       }
       
       if(xBlanc==330){
         if(yBlanc<=730 && yBlanc>=690){
           yBlanc=yBlanc+40;}
       }
          
   simulate();
   if(direction==1 ){//droite
     if (tab[ycase][(xcase+1)%20]==1){ //le xcase+1 definie la case qui suit
     x=xdep;
     y=ydep;
 }
   }
   if(direction==-1 ){//gauche
   if (tab[ycase][(xcase-1)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
 if(direction2 == -1){//haut
   if (tab[ycase-1][(xcase)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
   
   if(direction2 == 1  ){//bas
   if (tab[ycase+1][(xcase)%20]==1){
     x=xdep;
     y=ydep;
 }
   }
 renderDifficile();
  }
  
  if(etape==3){
exit();
  }
  }
  
 void simulate() {
  if ( !halt) {
    x += speed * direction;
    y += speed * direction2;
    x = (x + width) % width;
    y = (y + height) % height;
  }
 
}



void render() { 
  background(0);
  text("pour changer de musique appuyer soit sur a,z,e,r,t,y",60,30);
      
    affiche(tab);

  fill(255, 255, 0);// couleur pacman
 
  
  PImage Rouge;
    Rouge = loadImage("FantomeRougeMillieu.png");
    image(Rouge,xRouge,yRouge,taillePC,taillePC);
      PImage Rose;
      Rose = loadImage("FantomeRoseMillieu.png");
      image(Rose,xRose,yRose,taillePC,taillePC);
        PImage Orange;
        Orange = loadImage("FantomeOrangeMillieu.png");
        image(Orange,xOrange,yOrange,taillePC,taillePC);
          PImage Bleue;
          Bleue = loadImage("FantomeBleueMillieu.png");
          image(Bleue,xBleue,yBleue,taillePC,taillePC);
           
  
  if(y<75){//pacman se bloque en haut
     x=xdep;
     y=ydep;
   }
   
  if(x<30){//pacman se bloque a gauche de la fenetre
     x=xdep;
     y=ydep;
   }
    
    if(y>800){//pacman se bloque en bas de la fenetre
     x=xdep;
     y=ydep;
   }
   
    if(x>750){//pacman se bloque a droite de la fenetre
     x=xdep;
     y=ydep;
   }
  
   
     if(direction==1 ){//droite
     if (tab[ycase][(xcase)%20]==0){ //le xcase+1 definie la case qui suit
   tab[ycase][(xcase)%20]=2;
   compteur=compteur+1;
 }
   }
   
  if(direction==-1 ){//gauche
   if (tab[ycase][(xcase)%20]==0){
      tab[ycase][(xcase)%20]=2;
      compteur=compteur+1;
 }
   }
 if(direction2 == -1){//haut
   if (tab[ycase][(xcase)%20]==0){
      tab[ycase][(xcase)%20]=2;
      compteur=compteur+1;
 }
   }
   
   if(direction2 == 1  ){//bas
   if (tab[ycase][(xcase)%20]==0){
      tab[ycase][(xcase)%20]=2;
      compteur=compteur+1;
 }
   }
   
   text("Vous avez "+compteur+" points",width/3,70);
   
    if(compteur==204){
      fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez gagner",125,450);
      noLoop();
    }
   
   if(xRouge==x-10 && yRouge==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xRose==x-10 && yRose==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xOrange==x-10 && yOrange==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xBleue==x-10 && yBleue==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
  for ( int i=-1; i < 2; i++) {
    for ( int j=-1; j < 2; j++) {
      pushMatrix();
      translate(x + (i * width), y + (j*height));
      if ( direction == -1) { 
        rotate(PI);
      }
      if ( direction2 == 1) { 
        rotate(HALF_PI);
      }
      if ( direction2 == -1) { 
        rotate( PI + HALF_PI );
      }
      arc(0, 0, pacSize, pacSize, map((millis() % 500), 0, 500, 0, 1), map((millis() % 500), 0, 500, TWO_PI, 5.76) );
      popMatrix();
    }
  }
   
   stroke(0,0,255);//couleur ligne
  line(761,79,761,800);//ligne de droite
  line(39,800,761,800);//ligne du bas
  line(39,79,761,79);//ligne du haut
  line(39,79,39,800);//ligne de gauche
  
   
}


void renderMoyen() { 
  background(0);
  text("pour changer de musique appuyer soit sur a,z,e,r,t,y",60,30);
      
    affiche(tab);

  fill(255, 255, 0);// couleur pacman
 
  
  PImage Rouge;
    Rouge = loadImage("FantomeRougeMillieu.png");
    image(Rouge,xRouge,yRouge,taillePC,taillePC);
      PImage Rose;
      Rose = loadImage("FantomeRoseMillieu.png");
      image(Rose,xRose,yRose,taillePC,taillePC);
        PImage Orange;
        Orange = loadImage("FantomeOrangeMillieu.png");
        image(Orange,xOrange,yOrange,taillePC,taillePC);
          PImage Bleue;
          Bleue = loadImage("FantomeBleueMillieu.png");
          image(Bleue,xBleue,yBleue,taillePC,taillePC);
           PImage Vert;
          Vert = loadImage("FantomeVertMillieu.png");
          image(Vert,xVert,yVert,taillePC,taillePC);
  
  if(y<75){//pacman se bloque en haut
     x=xdep;
     y=ydep;
   }
   
  if(x<30){//pacman se bloque a gauche de la fenetre
     x=xdep;
     y=ydep;
   }
    
    if(y>800){//pacman se bloque en bas de la fenetre
     x=xdep;
     y=ydep;
   }
   
    if(x>750){//pacman se bloque a droite de la fenetre
     x=xdep;
     y=ydep;
   }
  
   
     if(direction==1 ){//droite
     if (tab[ycase][(xcase)%20]==0){ //le xcase+1 definie la case qui suit
   tab[ycase][(xcase)%20]=2;
   compteur=compteur+1;
 }
   }
   
  if(direction==-1 ){//gauche
   if (tab[ycase][(xcase)%20]==0){
      tab[ycase][(xcase)%20]=2;
      compteur=compteur+1;
 }
   }
 if(direction2 == -1){//haut
   if (tab[ycase][(xcase)%20]==0){
      tab[ycase][(xcase)%20]=2;
      compteur=compteur+1;
 }
   }
   
   if(direction2 == 1  ){//bas
   if (tab[ycase][(xcase)%20]==0){
      tab[ycase][(xcase)%20]=2;
      compteur=compteur+1;
 }
   }

   text("Vous avez "+compteur+" points",width/3,70);
   
    if(compteur==204){
      fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez gagner",125,450);
      noLoop();
    }
   
   if(xRouge==x-10 && yRouge==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xRose==x-10 && yRose==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xOrange==x-10 && yOrange==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xBleue==x-10 && yBleue==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xVert==x-10 && yVert==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
  for ( int i=-1; i < 2; i++) {
    for ( int j=-1; j < 2; j++) {
      pushMatrix();
      translate(x + (i * width), y + (j*height));
      if ( direction == -1) { 
        rotate(PI);
      }
      if ( direction2 == 1) { 
        rotate(HALF_PI);
      }
      if ( direction2 == -1) { 
        rotate( PI + HALF_PI );
      }
      arc(0, 0, pacSize, pacSize, map((millis() % 500), 0, 500, 0, 1), map((millis() % 500), 0, 500, TWO_PI, 5.76) );
      popMatrix();
    }
  }
   
   stroke(0,0,255);//couleur ligne
  line(761,79,761,800);//ligne de droite
  line(39,800,761,800);//ligne du bas
  line(39,79,761,79);//ligne du haut
  line(39,79,39,800);//ligne de gauche
  
   
}


void renderDifficile() { 
  background(0);
  text("pour changer de musique appuyer soit sur a,z,e,r,t,y",60,30);
      
    affiche(tab);

  fill(255, 255, 0);// couleur pacman
 
  
  PImage Rouge;
    Rouge = loadImage("FantomeRougeMillieu.png");
    image(Rouge,xRouge,yRouge,taillePC,taillePC);
      PImage Rose;
      Rose = loadImage("FantomeRoseMillieu.png");
      image(Rose,xRose,yRose,taillePC,taillePC);
        PImage Orange;
        Orange = loadImage("FantomeOrangeMillieu.png");
        image(Orange,xOrange,yOrange,taillePC,taillePC);
          PImage Bleue;
          Bleue = loadImage("FantomeBleueMillieu.png");
          image(Bleue,xBleue,yBleue,taillePC,taillePC);
           PImage Vert;
          Vert = loadImage("FantomeVertMillieu.png");
          image(Vert,xVert,yVert,taillePC,taillePC);
            PImage Blanc;
          Blanc = loadImage("FantomeBlancMillieu.png");
          image(Blanc,xBlanc,yBlanc,taillePC,taillePC);
  
  if(y<75){//pacman se bloque en haut
     x=xdep;
     y=ydep;
   }
   
  if(x<30){//pacman se bloque a gauche de la fenetre
     x=xdep;
     y=ydep;
   }
    
    if(y>800){//pacman se bloque en bas de la fenetre
     x=xdep;
     y=ydep;
   }
   
    if(x>750){//pacman se bloque a droite de la fenetre
     x=xdep;
     y=ydep;
   }
  
   
     if(direction==1 ){//droite
     if (tab[ycase][(xcase)%20]==0){ //le xcase+1 definie la case qui suit
   tab[ycase][(xcase)%20]=2;
   compteur=compteur+1;
 }
   }
   
  if(direction==-1 ){//gauche
   if (tab[ycase][(xcase)%20]==0){
      tab[ycase][(xcase)%20]=2;
      compteur=compteur+1;
 }
   }
 if(direction2 == -1){//haut
   if (tab[ycase][(xcase)%20]==0){
      tab[ycase][(xcase)%20]=2;
      compteur=compteur+1;
 }
   }
   
   if(direction2 == 1  ){//bas
   if (tab[ycase][(xcase)%20]==0){
      tab[ycase][(xcase)%20]=2;
      compteur=compteur+1;
 }
   }

   text("Vous avez "+compteur+" points",width/3,70);
   
    if(compteur==204){
      fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez gagner",125,450);
      noLoop();
    }
   
   if(xRouge==x-10 && yRouge==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xRose==x-10 && yRose==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xOrange==x-10 && yOrange==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xBleue==x-10 && yBleue==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xVert==x-10 && yVert==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
   if(xBlanc==x-10 && yBlanc==y-10){
     fill(255,0,0);
      PFont police; 
       police=loadFont ("AlmonteSnow-99.vlw");
      textFont(police);
      text("vous avez perdu",125,450);
      noLoop();
   }
   
  for ( int i=-1; i < 2; i++) {
    for ( int j=-1; j < 2; j++) {
      pushMatrix();
      translate(x + (i * width), y + (j*height));
      if ( direction == -1) { 
        rotate(PI);
      }
      if ( direction2 == 1) { 
        rotate(HALF_PI);
      }
      if ( direction2 == -1) { 
        rotate( PI + HALF_PI );
      }
      arc(0, 0, pacSize, pacSize, map((millis() % 500), 0, 500, 0, 1), map((millis() % 500), 0, 500, TWO_PI, 5.76) );
      popMatrix();
    }
  }
   
   stroke(0,0,255);//couleur ligne
  line(761,79,761,800);//ligne de droite
  line(39,800,761,800);//ligne du bas
  line(39,79,761,79);//ligne du haut
  line(39,79,39,800);//ligne de gauche
  
   
}

void keyPressed() {
  if ( key == CODED) {
    if ( keyCode == UP || keyCode == DOWN || keyCode == LEFT || keyCode == RIGHT ) {
      halt = true;
    }
  }
}

void keyReleased() { 
  if (key == CODED) {
    if (keyCode == RIGHT) {
      direction = 1;
      direction2 = 0;
      halt = false;
    }
    if (keyCode == LEFT) {      
      direction = -1;
      direction2 = 0;
      halt = false;
    }
    if (keyCode == DOWN) {
      direction = 0;
      direction2 = 1;
      halt = false;
    } 
    if (keyCode == UP) {
      direction = 0;
      direction2 = -1;
      halt = false;
    }
  }
}
  
  void musique(){
   /* code pour jouer le son */
  minim = new Minim(this);
  if(a==1){
  song = minim.loadFile ("popcorn.mp3");
    song.play(); 
  }
 if(a==2){
  song = minim.loadFile ("pirate.mp3");
    song.play(); 
  }
   if(a==3){
  song = minim.loadFile ("tetris2.mp3");
    song.play();
  }
   if(a==4){
  song = minim.loadFile ("tetris.mp3");
    song.play(); 
  }
  if(a==5){
  song = minim.loadFile ("jumpstyle.mp3");
    song.play(); 
  }
  if(a==6){
  song = minim.loadFile ("qemist.mp3");
    song.play(); 
  }
  }
 
  void stop() {
  minim.stop();
  super.stop();
  song.close();
}
