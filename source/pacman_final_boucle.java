import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 
import ddf.minim.signals.*; 
import ddf.minim.analysis.*; 
import ddf.minim.effects.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class pacman_final_boucle extends PApplet {





int compteur,Depart,etape,etapedifi;
int a=4;//musique de d\u00e9part
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
  
  public void setup(){
   
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
  
  public void draw(){
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
         text("difficult\u00e9",336,485);
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
    
    //Boucle Fant\u00f4me Rose
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
      
      
      //Boucle Fant\u00f4me Rouge
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
      
      
      //Boucle Fant\u00f4me Orange
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
  strokeWeight(2.5f);//epaisseur contour de la balle et contour menu


 if(etapedifi==4){//Facile
   xdep=x;
  ydep=y;
  xcase=x/40;
  ycase=y/40;
  
  //Boucle Fant\u00f4me Rose
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
      
      
      //Boucle Fant\u00f4me Rouge
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
      
      
      //Boucle Fant\u00f4me Orange
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
  
  //Boucle Fant\u00f4me Rose
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
      
      
      //Boucle Fant\u00f4me Rouge
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
      
      
      //Boucle Fant\u00f4me Orange
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
  
  //Boucle Fant\u00f4me Rose
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
      
      
      //Boucle Fant\u00f4me Rouge
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
      
      
      //Boucle Fant\u00f4me Orange
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
  
 public void simulate() {
  if ( !halt) {
    x += speed * direction;
    y += speed * direction2;
    x = (x + width) % width;
    y = (y + height) % height;
  }
 
}



public void render() { 
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
      arc(0, 0, pacSize, pacSize, map((millis() % 500), 0, 500, 0, 1), map((millis() % 500), 0, 500, TWO_PI, 5.76f) );
      popMatrix();
    }
  }
   
   stroke(0,0,255);//couleur ligne
  line(761,79,761,800);//ligne de droite
  line(39,800,761,800);//ligne du bas
  line(39,79,761,79);//ligne du haut
  line(39,79,39,800);//ligne de gauche
  
   
}


public void renderMoyen() { 
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
      arc(0, 0, pacSize, pacSize, map((millis() % 500), 0, 500, 0, 1), map((millis() % 500), 0, 500, TWO_PI, 5.76f) );
      popMatrix();
    }
  }
   
   stroke(0,0,255);//couleur ligne
  line(761,79,761,800);//ligne de droite
  line(39,800,761,800);//ligne du bas
  line(39,79,761,79);//ligne du haut
  line(39,79,39,800);//ligne de gauche
  
   
}


public void renderDifficile() { 
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
      arc(0, 0, pacSize, pacSize, map((millis() % 500), 0, 500, 0, 1), map((millis() % 500), 0, 500, TWO_PI, 5.76f) );
      popMatrix();
    }
  }
   
   stroke(0,0,255);//couleur ligne
  line(761,79,761,800);//ligne de droite
  line(39,800,761,800);//ligne du bas
  line(39,79,761,79);//ligne du haut
  line(39,79,39,800);//ligne de gauche
  
   
}

public void keyPressed() {
  if ( key == CODED) {
    if ( keyCode == UP || keyCode == DOWN || keyCode == LEFT || keyCode == RIGHT ) {
      halt = true;
    }
  }
}

public void keyReleased() { 
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
  
  public void musique(){
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
 
  public void stop() {
  minim.stop();
  super.stop();
  song.close();
}

public int[][] carte(){
  size(800,850);
  int [][]tab=new int[22][20];

     
     tab[2][0]=0;
     tab[2][1]=0;
     tab[2][2]=0;
     tab[2][3]=0;
     tab[2][4]=0;
     tab[2][5]=0;
     tab[2][6]=0;
     tab[2][7]=0;
     tab[2][8]=0;
     tab[2][9]=0;
     tab[2][10]=0;
     tab[2][11]=0;
     tab[2][12]=0;
     tab[2][13]=0;
     tab[2][14]=0;
     tab[2][15]=0;
     tab[2][16]=0;
     tab[2][17]=0;
     tab[2][18]=0;
     tab[2][19]=0;

     tab[3][0]=0;
     tab[3][1]=0;
     tab[3][2]=1;
     tab[3][3]=1;
     tab[3][4]=0;
     tab[3][5]=1;
     tab[3][6]=0;
     tab[3][7]=1;
     tab[3][8]=1;
     tab[3][9]=1;
     tab[3][10]=1;
     tab[3][11]=1;
     tab[3][12]=1;
     tab[3][13]=0;
     tab[3][14]=1;
     tab[3][15]=0;
     tab[3][16]=1;
     tab[3][17]=1;
     tab[3][18]=0;
     tab[3][19]=0;
  
     tab[4][0]=0;
     tab[4][1]=0;
     tab[4][2]=0;
     tab[4][3]=0;
     tab[4][4]=0;
     tab[4][5]=0;
     tab[4][6]=0;
     tab[4][7]=0;
     tab[4][8]=0;
     tab[4][9]=0;
     tab[4][10]=0;
     tab[4][11]=0;
     tab[4][12]=0;
     tab[4][13]=0;
     tab[4][14]=0;
     tab[4][15]=0;
     tab[4][16]=0;
     tab[4][17]=0;
     tab[4][18]=0;
     tab[4][19]=0;
     
     tab[5][0]=0;
     tab[5][1]=0;
     tab[5][2]=1;
     tab[5][3]=1;
     tab[5][4]=0;
     tab[5][5]=1;
     tab[5][6]=1;
     tab[5][7]=1;
     tab[5][8]=0;
     tab[5][9]=1;
     tab[5][10]=1;
     tab[5][11]=0;
     tab[5][12]=1;
     tab[5][13]=1;
     tab[5][14]=1;
     tab[5][15]=0;
     tab[5][16]=1;
     tab[5][17]=1;
     tab[5][18]=0;
     tab[5][19]=0;
     
     tab[6][0]=0;
     tab[6][1]=0;
     tab[6][2]=0;
     tab[6][3]=0;
     tab[6][4]=0;
     tab[6][5]=0;
     tab[6][6]=0;
     tab[6][7]=0;
     tab[6][8]=0;
     tab[6][9]=1;
     tab[6][10]=1;
     tab[6][11]=0;
     tab[6][12]=0;
     tab[6][13]=0;
     tab[6][14]=0;
     tab[6][15]=0;
     tab[6][16]=0;
     tab[6][17]=0;
     tab[6][18]=0;
     tab[6][19]=0;
     
     tab[7][0]=0;
     tab[7][1]=0;
     tab[7][2]=0;
     tab[7][3]=1;
     tab[7][4]=0;
     tab[7][5]=1;
     tab[7][6]=0;
     tab[7][7]=1;
     tab[7][8]=1;
     tab[7][9]=1;
     tab[7][10]=1;
     tab[7][11]=1;
     tab[7][12]=1;
     tab[7][13]=0;
     tab[7][14]=1;
     tab[7][15]=0;
     tab[7][16]=1;
     tab[7][17]=0;
     tab[7][18]=0;
     tab[7][19]=0;
     
     tab[8][0]=0;
     tab[8][1]=1;
     tab[8][2]=0;
     tab[8][3]=1;
     tab[8][4]=0;
     tab[8][5]=1;
     tab[8][6]=0;
     tab[8][7]=0;
     tab[8][8]=0;
     tab[8][9]=0;
     tab[8][10]=0;
     tab[8][11]=0;
     tab[8][12]=0;
     tab[8][13]=0;
     tab[8][14]=1;
     tab[8][15]=0;
     tab[8][16]=1;
     tab[8][17]=0;
     tab[8][18]=1;
     tab[8][19]=0;
     
     tab[9][0]=0;
     tab[9][1]=0;
     tab[9][2]=0;
     tab[9][3]=0;
     tab[9][4]=0;
     tab[9][5]=0;
     tab[9][6]=0;
     tab[9][7]=1;
     tab[9][8]=1;
     tab[9][9]=1;
     tab[9][10]=1;
     tab[9][11]=1;
     tab[9][12]=1;
     tab[9][13]=0;
     tab[9][14]=0;
     tab[9][15]=0;
     tab[9][16]=0;
     tab[9][17]=0;
     tab[9][18]=0;
     tab[9][19]=0;
     
     tab[10][0]=0;
     tab[10][1]=0;
     tab[10][2]=1;
     tab[10][3]=1;
     tab[10][4]=0;
     tab[10][5]=1;
     tab[10][6]=0;
     tab[10][7]=1;
     tab[10][8]=1;
     tab[10][9]=1;
     tab[10][10]=1;
     tab[10][11]=1;
     tab[10][12]=1;
     tab[10][13]=0;
     tab[10][14]=1;
     tab[10][15]=0;
     tab[10][16]=1;
     tab[10][17]=1;
     tab[10][18]=0;
     tab[10][19]=0;
     
     tab[11][0]=0;
     tab[11][1]=0;
     tab[11][2]=1;
     tab[11][3]=1;
     tab[11][4]=0;
     tab[11][5]=1;
     tab[11][6]=0;
     tab[11][7]=0;
     tab[11][8]=0;
     tab[11][9]=0;
     tab[11][10]=0;
     tab[11][11]=0;
     tab[11][12]=0;
     tab[11][13]=0;
     tab[11][14]=1;
     tab[11][15]=0;
     tab[11][16]=1;
     tab[11][17]=1;
     tab[11][18]=0;
     tab[11][19]=0;
     
     tab[12][0]=0;
     tab[12][1]=0;
     tab[12][2]=0;
     tab[12][3]=0;
     tab[12][4]=0;
     tab[12][5]=1;
     tab[12][6]=1;
     tab[12][7]=1;
     tab[12][8]=0;
     tab[12][9]=1;
     tab[12][10]=1;
     tab[12][11]=0;
     tab[12][12]=1;
     tab[12][13]=1;
     tab[12][14]=1;
     tab[12][15]=0;
     tab[12][16]=0;
     tab[12][17]=0;
     tab[12][18]=0;
     tab[12][19]=0;
     
     tab[13][0]=0;
     tab[13][1]=0;
     tab[13][2]=0;
     tab[13][3]=1;
     tab[13][4]=0;
     tab[13][5]=1;
     tab[13][6]=0;
     tab[13][7]=0;
     tab[13][8]=0;
     tab[13][9]=1;
     tab[13][10]=1;
     tab[13][11]=0;
     tab[13][12]=0;
     tab[13][13]=0;
     tab[13][14]=1;
     tab[13][15]=0;
     tab[13][16]=1;
     tab[13][17]=0;
     tab[13][18]=0;
     tab[13][19]=0;
     
     tab[14][0]=0;
     tab[14][1]=1;
     tab[14][2]=0;
     tab[14][3]=1;
     tab[14][4]=0;
     tab[14][5]=1;
     tab[14][6]=0;
     tab[14][7]=1;
     tab[14][8]=1;
     tab[14][9]=1;
     tab[14][10]=1;
     tab[14][11]=1;
     tab[14][12]=1;
     tab[14][13]=0;
     tab[14][14]=1;
     tab[14][15]=0;
     tab[14][16]=1;
     tab[14][17]=0;
     tab[14][18]=1;
     tab[14][19]=0;
     
     tab[15][0]=0;
     tab[15][1]=0;
     tab[15][2]=0;
     tab[15][3]=0;
     tab[15][4]=0;
     tab[15][5]=1;
     tab[15][6]=0;
     tab[15][7]=0;
     tab[15][8]=0;
     tab[15][9]=0;
     tab[15][10]=0;
     tab[15][11]=0;
     tab[15][12]=0;
     tab[15][13]=0;
     tab[15][14]=1;
     tab[15][15]=0;
     tab[15][16]=0;
     tab[15][17]=0;
     tab[15][18]=0;
     tab[15][19]=0;
     
     tab[16][0]=0;
     tab[16][1]=0;
     tab[16][2]=1;
     tab[16][3]=1;
     tab[16][4]=0;
     tab[16][5]=1;
     tab[16][6]=0;
     tab[16][7]=1;
     tab[16][8]=1;
     tab[16][9]=1;
     tab[16][10]=1;
     tab[16][11]=1;
     tab[16][12]=1;
     tab[16][13]=0;
     tab[16][14]=1;
     tab[16][15]=0;
     tab[16][16]=1;
     tab[16][17]=1;
     tab[16][18]=0;
     tab[16][19]=0;
     
     tab[17][0]=0;
     tab[17][1]=0;
     tab[17][2]=0;
     tab[17][3]=0;
     tab[17][4]=0;
     tab[17][5]=0;
     tab[17][6]=0;
     tab[17][7]=0;
     tab[17][8]=0;
     tab[17][9]=1;
     tab[17][10]=1;
     tab[17][11]=0;
     tab[17][12]=0;
     tab[17][13]=0;
     tab[17][14]=0;
     tab[17][15]=0;
     tab[17][16]=0;
     tab[17][17]=0;
     tab[17][18]=0;
     tab[17][19]=0;
     
     tab[18][0]=0;
     tab[18][1]=0;
     tab[18][2]=1;
     tab[18][3]=1;
     tab[18][4]=0;
     tab[18][5]=1;
     tab[18][6]=1;
     tab[18][7]=1;
     tab[18][8]=0;
     tab[18][9]=1;
     tab[18][10]=1;
     tab[18][11]=0;
     tab[18][12]=1;
     tab[18][13]=1;
     tab[18][14]=1;
     tab[18][15]=0;
     tab[18][16]=1;
     tab[18][17]=1;
     tab[18][18]=0;
     tab[18][19]=0;
     
     tab[19][0]=0;
     tab[19][1]=0;
     tab[19][2]=0;
     tab[19][3]=0;
     tab[19][4]=0;
     tab[19][5]=0;
     tab[19][6]=0;
     tab[19][7]=0;
     tab[19][8]=0;
     tab[19][9]=0;
     tab[19][10]=0;
     tab[19][11]=0;
     tab[19][12]=0;
     tab[19][13]=0;
     tab[19][14]=0;
     tab[19][15]=0;
     tab[19][16]=0;
     tab[19][17]=0;
     tab[19][18]=0;
     tab[19][19]=0;
  
   /* tab[20][0]=0;
     tab[20][1]=1;
     tab[20][2]=1;
     tab[20][3]=1;
     tab[20][4]=1;
     tab[20][5]=1;
     tab[20][6]=1;
     tab[20][7]=1;
     tab[20][8]=0;
     tab[20][9]=1;
     tab[20][10]=1;
     tab[20][11]=0;
     tab[20][12]=1;
     tab[20][13]=1;
     tab[20][14]=1;
     tab[20][15]=1;
     tab[20][16]=1;
     tab[20][17]=1;
     tab[20][18]=1;
     tab[20][19]=0;
   
   */
    return(tab);
      
}
public void bleu(int i,int j){
 
  fill(0,0,153);
  rect(j*40,i*40,40,40);
}

public void noir(int i,int j){
 
  fill(0,0,0);
  rect(j*40,i*40,40,40);
}

  public void pacgum(int i,int j){
  
  fill(255,255,0);
  
  ellipse(20+j*40,20+i*40,12,12);
  
  
  }
public void affiche(int[][] tab){
   for (int j=1;j<19;j++){
      for (int i=2;i<20;i++){
     
     
    if(tab[i][j]==1){
      bleu(i,j);
    }
    
   
   if(tab[i][j]==0){
      pacgum(i,j);
      }
   if(tab[i][j]==2){
      noir(i,j);   
      }
   }
   
}
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "pacman_final_boucle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
