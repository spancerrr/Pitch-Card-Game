
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;



import java.util.Iterator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;

public class Game extends Application{
 
	TextField text;
	Button img;
	Button btn, btn2,changeP;//start buttons
	Button x, y, z, m;//choose number player buttons
	Button bid1,bid2,bid3,bid4,pass,m4;//bids
	Button m2, c1, c2, c3, c4, c5, c6, e2,s,sGame, sHand, playC;//play game button
	Button p1Score,ai1Score,ai2Score,ai3Score,ai1Bid,ai2Bid,ai3Bid,p1Bid, m5;//show player info buttons
	Button m3, e, next;//finish round button
	Stage myStage;
	Scene scene, scene2,scene3;
	HashMap<String, Scene> sceneMap;
	int numPlayer= 0;
	int roundNum = 0;
	int score = 0;
	int counter = 0;
	Deck playingDeck;
	Player myPlayer;
	AIPlayer ai1;
	AIPlayer ai2 = new AIPlayer();
	AIPlayer ai3 = new AIPlayer();
	Pitch dealer;
	String showPBid;
	Label l = new Label("");
	Label bidLabel = new Label("");
	Label ai1BidLabel = new Label("");
	Label ai2BidLabel = new Label("");
	Label ai3BidLabel = new Label("");
	Label allPassBid = new Label("");
	Label cardPLabel = new Label("");
	Label startLabel = new Label("");
	Label scoreLabel = new Label("");
	Label scoreLabel1 = new Label("");
	Label scoreLabel2 = new Label("");
	Label scoreLabel3 = new Label("");
	Label roundLabel = new Label("");
	Label roundLabel2 = new Label("");
	Label cardPlayed = new Label("");
	Label cardPlayed1 = new Label("");
	Label cardPlayed2 = new Label("");
	Label cardPlayed3 = new Label("");
	Label trumpLabel = new Label("");
	Label turnLabel = new Label("");
	Label high = new Label("");
	Label low = new Label("");
	Label jack = new Label("");
	Label all = new Label("");
	Label points = new Label("");
	Label roundS = new Label("");
	Label roundS1 = new Label("");
	Label roundS2 = new Label("");
	Label roundS3 = new Label("");
	
public static void main(String[] args) {
	launch(args);
}
 
public static void sleep(int time)
{
	try {
		Thread.sleep(time);
	}catch(Exception e) {}
}
public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle("Pitch Card Game");
	sceneMap = new HashMap<String, Scene>();
	myStage = primaryStage;
	text = new TextField();
	
	//start scene buttons
	btn = new Button("Exit Game");
	btn2 = new Button("Start Game");
	changeP = new Button("Change number of player");
	x =new Button("Two");
	y = new Button("three");
	z = new Button("four");
	//start button
		btn2.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
					if(x.isDisabled() == true)
					{
						myStage.setScene(sceneMap.get("gamePlay"));
					}else
					{
						startLabel.setText("You need to select number of players before start the game!");
						l.setText("player number is not selected yet!");
					}
			}
		});
		
		//exit
		btn.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				System.exit(0);
			}
		});
		
		changeP.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				x.setDisable(false);
				y.setDisable(false);
				z.setDisable(false);
				l.setText("");
				myPlayer.setNumPlayer(0);
			}
		});
	
	//choose number of players  and places bid button
	//deal cards for two player
	x.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event){
			dealer = new Pitch();
			dealer.createDealer();
			//dealer = new PitchDealer();
			myPlayer = new Player();
			myPlayer.setNumPlayer(2);
			playingDeck = new Deck();
			playingDeck.createDeck();
			playingDeck.shuffle();
			myPlayer.getCards(2,playingDeck);//deal cards for player
			dealer.getDealer().initalBids();
			//dealer.getDealer().initalBids();
			
			//set up 1 AI player
			ai1 = new AIPlayer();
			ai1.getAICards(2,playingDeck);
			//ai1.initalBids();
			//ai1BidLabel.setText("Player2 bid: " + ai1.getAIBid());
			
			//set up card button
			c1.setText(myPlayer.cardLabel(0));
			c2.setText(myPlayer.cardLabel(1));
			c3.setText(myPlayer.cardLabel(2));
			c4.setText(myPlayer.cardLabel(3));
			c5.setText(myPlayer.cardLabel(4));
			c6.setText(myPlayer.cardLabel(5));
	
			x.setDisable(true);
			y.setDisable(true);
			z.setDisable(true);
			btn.setDisable(false);
			btn2.setDisable(false);
			changeP.setDisable(false);
			l.setText("You selected 2 player, click 'Start Game' to start the game");//change label
			startLabel.setText("");
			
		}
	});
	
	//deal cards for three player
	y.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event){
			dealer = new Pitch();
			dealer.createDealer();
			//dealer = new PitchDealer();
			myPlayer = new Player();
			myPlayer.setNumPlayer(3);
			playingDeck = new Deck();
			playingDeck.createDeck();
			playingDeck.shuffle();
			myPlayer.getCards(3,playingDeck);
			//dealer.getDealer().initalBids();
			dealer.getDealer().initalBids();
			
			//set up 2 AI player
			ai1 = new AIPlayer();
			ai2 = new AIPlayer();
			ai1.getAICards(2,playingDeck);
			ai2.getAICards(1,playingDeck);
			/*ai1.initalBids();
			ai2.initalBids();*/
			
			//set up card button
			c1.setText(myPlayer.cardLabel(0));
			c2.setText(myPlayer.cardLabel(1));
			c3.setText(myPlayer.cardLabel(2));
			c4.setText(myPlayer.cardLabel(3));
			c5.setText(myPlayer.cardLabel(4));
			c6.setText(myPlayer.cardLabel(5));
			
			x.setDisable(true);
			y.setDisable(true);
			z.setDisable(true);
			btn.setDisable(false);
			btn2.setDisable(false);
			changeP.setDisable(false);
			l.setText("You selected 3 player,click 'Start Game' to start the game");
			startLabel.setText("");
		}
	});
	
	//deal cards for four player
	z.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event){
			dealer = new Pitch();
			dealer.createDealer();
			myPlayer = new Player();
			myPlayer.setNumPlayer(4);
			playingDeck = new Deck();
			playingDeck.createDeck();
			playingDeck.shuffle();
			myPlayer.getCards(4,playingDeck);
			//dealer.getDealer().initalBids();
			dealer.getDealer().initalBids();
			//set up 3 AI player
			ai1 = new AIPlayer();
			ai2 = new AIPlayer();
			ai3 = new AIPlayer();
			ai1.getAICards(3,playingDeck);
			ai2.getAICards(2,playingDeck);
			ai3.getAICards(1,playingDeck);
			
			
			//set up card button
			c1.setText(myPlayer.cardLabel(0));
			c2.setText(myPlayer.cardLabel(1));
			c3.setText(myPlayer.cardLabel(2));
			c4.setText(myPlayer.cardLabel(3));
			c5.setText(myPlayer.cardLabel(4));
			c6.setText(myPlayer.cardLabel(5));
			
			x.setDisable(true);
			y.setDisable(true);
			z.setDisable(true);
			btn.setDisable(false);
			btn2.setDisable(false);
			changeP.setDisable(false);
			l.setText("You selected 4 player,click 'Start Game' to start the game");
			startLabel.setText("");
		}
	});
	
	//bid  buttons
		m4 = new Button("Place your bid ");
		bid1 = new Button("2");
		bid2 = new Button("3");
		bid3 = new Button("4");
		bid4 = new Button("smudge");
		pass = new Button("pass");
		

		EventHandler<ActionEvent> gameBid = new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Button a = (Button)event.getSource();
				if(a == pass)
				{
					myPlayer.setBid(0);
					//dealer.getDealer().deleteBids(0,dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
					bidLabel.setText("You bid: pass");
				}else if(a == bid4)
				{
					myPlayer.setBid(5);
					dealer.getDealer().deleteBids(2,dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
					dealer.getDealer().deleteBids(3,dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
					dealer.getDealer().deleteBids(4,dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
					dealer.getDealer().deleteBids(5,dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
					bidLabel.setText("You bid: smudge");
				}else 
				{
					if(a == bid1)
					{
						myPlayer.setBid(2);
						dealer.getDealer().deleteBids(2,dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
					}else if(a == bid2)
					{
						myPlayer.setBid(3);
						dealer.getDealer().deleteBids(2,dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
						dealer.getDealer().deleteBids(3,dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
					}else if(a == bid3)
					{
						myPlayer.setBid(4);
						dealer.getDealer().deleteBids(2,dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
						dealer.getDealer().deleteBids(3,dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
						dealer.getDealer().deleteBids(4,dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
					}
					bidLabel.setText("You bid: "+ myPlayer.getBid());
				}
				
				ai1.setAIBid(dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
				if(ai1.getAIBid() == 0)
				{
					ai1BidLabel.setText("Player2 bid: pass");
				}else if(ai1.getAIBid() == 5)
				{
					ai1BidLabel.setText("Player2 bid: smudge");
				}
				else
				{
					ai1BidLabel.setText("Player2 bid: " + ai1.getAIBid());
				}
				
				if(myPlayer.getNumPlayer() >= 3)
				{
					ai2.setAIBid(dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
					if(ai2.getAIBid() == 0)
					{
						ai2BidLabel.setText("Player3 bid: pass");
					}else if(ai2.getAIBid() == 5)
					{
						ai2BidLabel.setText("Player3 bid: smudge");
					}
					else
					{
						ai2BidLabel.setText("Player3 bid: " + ai2.getAIBid());
					}
				}
				if(myPlayer.getNumPlayer() == 4)
				{
					//ai3.deleteBids(2);
					ai3.setAIBid(dealer.getDealer().getAvaBids(),dealer.getDealer().getPlayerBids());
					if(ai3.getAIBid()==0)
					{
						ai3BidLabel.setText("Player4 bid: pass");
					}else if(ai3.getAIBid() == 5)
					{
						ai3BidLabel.setText("Player3 bid: smudge");
					}
					else
					{
						ai3BidLabel.setText("Player4 bid: " + ai3.getAIBid());
					}
				}
				
				bid1.setDisable(true);
				bid2.setDisable(true);
				bid3.setDisable(true);
				bid4.setDisable(true);
				pass.setDisable(true);
				cardPLabel.setText("");
				int b1 = myPlayer.getBid();
				int b2 = ai1.getAIBid();
				int b3 = 0,b4 = 0;
				if(myPlayer.getNumPlayer() >= 3)
				{
					b3 = ai2.getAIBid();
				}
				if(myPlayer.getNumPlayer() == 4)
				{
					b4 = ai3.getAIBid();
				}
				if( b1>b2 && b1>b3 && b1>b4)//player start
				{
					dealer.getDealer().setwhoStart(1);
				}else if(b2>b1 && b2>b3 && b2>b4)//ai1 start 
				{
					dealer.getDealer().setwhoStart(2);
				}else if(b3>b1 && b3>b2 && b3>b4)//ai2 start
				{
					dealer.getDealer().setwhoStart(3);
				}else if(b4>b1 && b4>b2 && b4>b3)//si3 start
				{
					dealer.getDealer().setwhoStart(4);
				}
				if(b1 == 0 && b2==0 && b3== 0 && b4 == 0)
				{
					bidLabel.setText("");
					ai1BidLabel.setText("");
					ai2BidLabel.setText("");
					ai3BidLabel.setText("");
					allPassBid.setText("All player passed bid, click continue to start a new round");
					next.setDisable(false);
					sGame.setDisable(true);
				}else
				{
					sGame.setDisable(false);
				}
			}
			
		};
		bid1.setOnAction(gameBid);
		bid2.setOnAction(gameBid);
		bid3.setOnAction(gameBid);
		bid4.setOnAction(gameBid);
		pass.setOnAction(gameBid);
		
	//play buttons
		m2 = new Button("Which card you want to play ");//print message
		e2 = new Button("Exit Game");
		s = new Button("Start New Game");
		
		sGame = new Button("Start this round");
		m5 =new Button("Players Info ");
		
		s.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				myPlayer = new Player();
				dealer = new Pitch();
				dealer.createDealer();
				l.setText("");
				startLabel.setText("");
				cardPLabel.setText("");
				bidLabel.setText("");
				ai1BidLabel.setText("");
				ai2BidLabel.setText("");
				ai3BidLabel.setText("");
				allPassBid.setText("");
				roundLabel.setText("");
				cardPlayed.setText("");
				cardPlayed1.setText("");
				cardPlayed2.setText("");
				cardPlayed3.setText("");
				roundLabel2.setText("");
				trumpLabel.setText("");
				high.setText("");
				low.setText("");
				jack.setText("");
				all.setText("");
				points.setText("");
				scoreLabel.setText("");
				scoreLabel1.setText("");
				scoreLabel2.setText("");
				scoreLabel3.setText("");
				roundS.setText("");
				roundS1.setText("");
				roundS2.setText("");
				roundS3.setText("");
				btn.setDisable(true);
				btn2.setDisable(true);
				changeP.setDisable(true);
				bid1.setDisable(false);
				bid2.setDisable(false);
				bid3.setDisable(false);
				bid4.setDisable(false);
				pass.setDisable(false);
				c1.setDisable(true);
				c2.setDisable(true);
				c3.setDisable(true);
				c4.setDisable(true);
				c5.setDisable(true);
				c6.setDisable(true);
				x.setDisable(false);
				y.setDisable(false);
				z.setDisable(false);
				myStage.setScene(sceneMap.get("welcome"));
			}
		});
		sHand = new Button();
		sHand.setText("Start hand");
		sHand.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
				Card ai1C;
				Card ai2C;
				Card ai3C;
				int who = dealer.getDealer().getWhoStart();
				if( who == 1)//player start
				{
					dealer.getDealer().setwhoStart(1);
					cardPlayed1.setText("");
					cardPlayed2.setText("");
					cardPlayed3.setText("");
				}else if(who == 2)//ai1 start 
				{
					dealer.getDealer().setwhoStart(2);
					//ai1.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
					ai1C = ai1.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
					dealer.getDealer().addCardPlayed(ai1C);
					cardPlayed1.setText("Player2 played: " + ai1C);
					cardPlayed.setText("Your turn! Which card do you want to play?");
					//cardPlayed.setText("Player2 played: " + ai1C);
					if(myPlayer.getNumPlayer() > 2)
					{
						ai2C = ai2.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
						cardPlayed2.setText("Player3 played: " + ai2C);
						dealer.getDealer().addCardPlayed(ai2C);
					}
					if(myPlayer.getNumPlayer() > 3)
					{
						ai3C = ai3.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
						cardPlayed3.setText("Player4 played: " + ai3C);
						dealer.getDealer().addCardPlayed(ai3C);
					}
				}else if(who == 3)//ai2 start
				{
					ai2C = ai2.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
					cardPlayed2.setText("Player3 played: " + ai2C);
					dealer.getDealer().addCardPlayed(ai2C);
					if(myPlayer.getNumPlayer() > 3)
					{
						ai3C = ai3.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
						cardPlayed3.setText("Player4 played: " + ai3C);
						dealer.getDealer().addCardPlayed(ai3C);
					}
					cardPlayed1.setText("");
				}else if(who == 4)//si3 start
				{
					ai3C = ai3.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
					cardPlayed3.setText("Player4 played: " + ai3C);
					dealer.getDealer().addCardPlayed(ai3C);
					cardPlayed1.setText("");
					cardPlayed2.setText("");
				}
				cardPlayed.setText("");
				roundLabel.setText("Player"+ dealer.getDealer().getWhoStart() + " start this hand");
				sHand.setDisable(true);
				if(c1.getText() != "")
					c1.setDisable(false);
				if(c2.getText() != "")
					c2.setDisable(false);
				if(c3.getText() != "")
					c3.setDisable(false);
				if(c4.getText() != "")
					c4.setDisable(false);
				if(c5.getText() != "")
					c5.setDisable(false);
				if(c6.getText() != "")
					c6.setDisable(false);
			}
			});
		
		sGame.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
				Card ai1C;
				Card ai2C;
				Card ai3C;
				int who = dealer.getDealer().getWhoStart();
				if( who == 1)//player start
				{
					dealer.getDealer().setwhoStart(1);
				}else if(who == 2)//ai1 start 
				{
					dealer.getDealer().setwhoStart(2);
					ai1C = ai1.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
					dealer.getDealer().addCardPlayed(ai1C);
					cardPlayed1.setText("Player2 played: " + ai1C);
					dealer.getDealer().setTrump(ai1C.getsuit());
					cardPlayed.setText("Your turn! Which card do you want to play?");
					//cardPlayed.setText("Player2 played: " + ai1C);
					if(myPlayer.getNumPlayer() > 2)
					{
						ai2C = ai2.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
						cardPlayed2.setText("Player3 played: " + ai2C);
						dealer.getDealer().addCardPlayed(ai2C);
					}
					if(myPlayer.getNumPlayer() > 3)
					{
						ai3C = ai3.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
						cardPlayed3.setText("Player4 played: " + ai3C);
						dealer.getDealer().addCardPlayed(ai3C);
					}
				}else if(who == 3)//ai2 start
				{
					ai2C = ai2.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
					dealer.getDealer().setTrump(ai2C.getsuit());
					cardPlayed2.setText("Player3 played: " + ai2C);
					dealer.getDealer().addCardPlayed(ai2C);
					if(myPlayer.getNumPlayer() > 3)
					{
						ai3C = ai3.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
						cardPlayed3.setText("Player4 played: " + ai3C);
						dealer.getDealer().addCardPlayed(ai3C);
					}
				}else if(who == 4)//si3 start
				{
					ai3C = ai3.playACard(dealer.getDealer().getCardPlayed(),dealer.getDealer().getTrump());
					dealer.getDealer().setTrump(ai3C.getsuit());
					cardPlayed3.setText("Player4 played: " + ai3C);
					dealer.getDealer().addCardPlayed(ai3C);
				}
				trumpLabel.setText("Trump Suit: " + dealer.getDealer().getTrump());
				cardPlayed.setText("Your turn!!");
				sGame.setDisable(true);
				if(c1.getText() != "")
					c1.setDisable(false);
				if(c2.getText() != "")
					c2.setDisable(false);
				if(c3.getText() != "")
					c3.setDisable(false);
				if(c4.getText() != "")
					c4.setDisable(false);
				if(c5.getText() != "")
					c5.setDisable(false);
				if(c6.getText() != "")
					c6.setDisable(false);
				}
			});
		
		//play one hand
		playC = new Button();
		playC.setText("Finish this hand");
		playC.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//determine who win this hand
	
				int tmp = dealer.getDealer().deterRound(dealer.getDealer().getCardPlayed(), dealer.getDealer().getTrump(),myPlayer.getNumPlayer());// tmp = who win the hand
				roundLabel.setText("This hand is finished, winner is player: " + tmp);
				if(tmp == 1)
				{
					myPlayer.addWinDeck(dealer.getDealer().getCardPlayed());
					dealer.getDealer().setwhoStart(1);
				}
				else if(tmp == 2)
				{
					ai1.addWinDeck(dealer.getDealer().getCardPlayed());
					dealer.getDealer().setwhoStart(2);
				}
				else if(tmp == 3)
				{
					ai2.addWinDeck(dealer.getDealer().getCardPlayed());
					dealer.getDealer().setwhoStart(3);
				}
				else if(tmp == 4)
				{
					ai3.addWinDeck(dealer.getDealer().getCardPlayed());
					dealer.getDealer().setwhoStart(4);
				}
				
				//if all 6 cards has been played
				if(c1.getText() == "" && c2.getText() == "" && c3.getText() == "" && c4.getText() == "" &&c5.getText() == ""&&c6.getText() == "")
				{
					next.setDisable(false);
					roundLabel2.setText("This round is finished, click continue to start next round ");
					//card points
					int p1,p2 = 0,p3 = 0,p;
					p = myPlayer.getCardsPoint();
					p1 = ai1.getCardsPoint();
					if(myPlayer.getNumPlayer() > 2)
						p2 = ai2.getCardsPoint();
					if(myPlayer.getNumPlayer() > 3)
						p3 = ai3.getCardsPoint();
					if(p > p1 && p > p2  && p >p3)
					{
						myPlayer.addRoundScore();
						points.setText("You have most card points");
					}
					else if(p1 > p && p1 > p2  && p1 > p3)
					{
						ai1.addRoundScore();
						points.setText("Player2 have most card points");
					}
					else if(p2 > p && p2 > p1  && p2 > p3)
					{
						ai2.addRoundScore();
						points.setText("Player3 have most card points");
					}
					else if(p3 > p && p3 > p2  && p3 > p1)
					{
						ai3.addRoundScore();
						points.setText("Player4 have most card points");
					}
					
					
					//high
					if(myPlayer.hasHigh(myPlayer.getWinDECK(),ai1.getWinDECK(),ai2.getWinDECK(),ai3.getWinDECK(), dealer.getDealer().getTrump(),myPlayer.getNumPlayer()) == true)
					{
						myPlayer.addRoundScore();
						high.setText("You have high trump card");
					}
					if(ai1.hasHigh(myPlayer.getWinDECK(),ai1.getWinDECK(),ai2.getWinDECK(),ai3.getWinDECK(), dealer.getDealer().getTrump(),myPlayer.getNumPlayer()) == true)
					{
						ai1.addRoundScore();
						high.setText("Player2 has high trump card");
					}
					
					//low
					if(myPlayer.hasLow(myPlayer.getWinDECK(),ai1.getWinDECK(),ai2.getWinDECK(),ai3.getWinDECK(), dealer.getDealer().getTrump(),myPlayer.getNumPlayer()) == true)
					{
						myPlayer.addRoundScore();
						low.setText("You have low trump card");
					}
					if(ai1.hasLow(myPlayer.getWinDECK(),ai1.getWinDECK(),ai2.getWinDECK(),ai3.getWinDECK(), dealer.getDealer().getTrump(),myPlayer.getNumPlayer()) == true)
					{
						ai1.addRoundScore();
						low.setText("Player2 have low trump card");
					}
					
					//jack
					if(myPlayer.hasJack(dealer.getDealer().getTrump()) == true)
					{
						myPlayer.addRoundScore();
						jack.setText("You have Trump Jack");
					}
					if(ai1.hasJack(dealer.getDealer().getTrump()) == true)
					{
						ai1.addRoundScore();
						jack.setText("Player2 have Trump Jack");
					}
					
					//all
					if(myPlayer.winAll(myPlayer.getNumPlayer()) == true)
					{
						myPlayer.addRoundScore();
						all.setText("You have won all hands");
					}
					if(ai1.winAll(myPlayer.getNumPlayer()) == true)
					{
						ai1.addRoundScore();
						all.setText("Player2 have won all hands");
					}
					if(myPlayer.getNumPlayer() > 2)
					{
						//high
						if(ai2.hasHigh(myPlayer.getWinDECK(),ai1.getWinDECK(),ai2.getWinDECK(),ai3.getWinDECK(), dealer.getDealer().getTrump(),myPlayer.getNumPlayer()) == true)
						{
							ai2.addRoundScore();
							high.setText("Player3 have high trump card");
						}
						//low
						if(ai2.hasLow(myPlayer.getWinDECK(),ai1.getWinDECK(),ai2.getWinDECK(),ai3.getWinDECK(), dealer.getDealer().getTrump(),myPlayer.getNumPlayer()) == true)
						{
							ai2.addRoundScore();
							low.setText("Player3 have low trump card");
						}
						//jack
						if(ai2.hasJack(dealer.getDealer().getTrump()) == true)
						{
							ai2.addRoundScore();
							jack.setText("Player2 have Trump Jack");
						}
						//all
						if(ai2.winAll(myPlayer.getNumPlayer()) == true)
						{
							ai2.addRoundScore();
							all.setText("Player3 have won all hands");
						}
						
					}
				
					if(myPlayer.getNumPlayer() > 3)
					{
						//high
						if(ai3.hasHigh(myPlayer.getWinDECK(),ai1.getWinDECK(),ai2.getWinDECK(),ai3.getWinDECK(), dealer.getDealer().getTrump(),myPlayer.getNumPlayer()) == true)
						{
							ai3.addRoundScore();
							high.setText("Player4 have high trump card");
						}
						//low
						if(ai3.hasLow(myPlayer.getWinDECK(),ai1.getWinDECK(),ai2.getWinDECK(),ai3.getWinDECK(), dealer.getDealer().getTrump(),myPlayer.getNumPlayer()) == true)
						{
							ai3.addRoundScore();
							low.setText("Player4 have low trump card");
						}
						//jack
						if(ai3.hasJack(dealer.getDealer().getTrump()) == true)
						{
							ai3.addRoundScore();
							jack.setText("Player4 have Trump Jack");
						}
						if(ai3.winAll(myPlayer.getNumPlayer()) == true)
						{
							ai3.addRoundScore();
							all.setText("Player4 have won all hands");
						}
						scoreLabel3.setText("Player4 score: " + ai3.getScore());
					}
					if(high.getText() == "")
						high.setText("No one have high trump card");
					if(low.getText() == "" )
						low.setText("No one have low trump card");
					if(jack.getText() == "")
						jack.setText("No one have Trump Jack");
					if(points.getText() == "")
						points.setText("No one have most card points");
					if(all.getText() == "")
						all.setText("No one won all 6 hands");
					
					if(myPlayer.getRoundScore() >= myPlayer.getBid() && myPlayer.getBid() != 0)
					{
						myPlayer.setScore(myPlayer.getScore() + myPlayer.getBid());
					}
					else if(myPlayer.getBid() == 0)
					{
						for(Integer bid : dealer.getDealer().getPlayerBids())
						{
							if(bid.equals(myPlayer.getRoundScore()))
							{
								myPlayer.setScore(myPlayer.getScore() + myPlayer.getRoundScore());
							}
						}
					}
					else
						myPlayer.setScore(myPlayer.getScore() - myPlayer.getBid());
					roundS.setText("Your round score: " + myPlayer.getRoundScore() + "    Your bid: " + myPlayer.getBid());
					
					if(ai1.getRoundScore() >= ai1.getAIBid() && ai1.getAIBid() != 0)
					{
						ai1.setScore(ai1.getScore() + ai1.getAIBid());
					}
					else if(ai1.getAIBid() == 0)
					{
						for(Integer bid : dealer.getDealer().getPlayerBids())
						{
							if(bid.equals(ai1.getRoundScore()))
							{
								ai1.setScore(ai1.getScore() + ai1.getRoundScore());
							}
						}
					}
					else
					{
						ai1.setScore(ai1.getScore() - ai1.getAIBid());
					}
					roundS1.setText("Player2 round score: " + ai1.getRoundScore() + " Player2 bid: " + ai1.getAIBid());
					
					if(myPlayer.getNumPlayer() > 2)
					{
						if(ai2.getRoundScore() >= ai2.getAIBid() && ai2.getAIBid() != 0)
						{
							ai2.setScore(ai2.getScore() + ai2.getAIBid());
						}
						else if(ai2.getAIBid() == 0)
						{
							for(Integer bid : dealer.getDealer().getPlayerBids())
							{
								if(bid.equals(ai2.getRoundScore()))
								{
									ai2.setScore(ai2.getScore() + ai2.getRoundScore());
								}
							}
						}
						else
						{
							ai2.setScore(ai2.getScore() - ai2.getAIBid());
						}
						roundS2.setText("Player3 round score: " + ai2.getRoundScore() + " Player3 bid: " + ai2.getAIBid());
						scoreLabel2.setText("Player3 score: " + ai2.getScore());
					}
					if(myPlayer.getNumPlayer() > 3)
					{
						if(ai3.getRoundScore() >= ai3.getAIBid() && ai3.getAIBid() != 0)
						{
							ai3.setScore(ai3.getScore() + ai3.getAIBid());
						}
						else if(ai3.getAIBid() == 0)
						{
							for(Integer bid : dealer.getDealer().getPlayerBids())
							{
								if(bid.equals(ai3.getRoundScore()))
								{
									ai3.setScore(ai3.getScore() + ai3.getRoundScore());
								}
							}
						}
						else {
							ai3.setScore(ai3.getScore() - ai3.getAIBid());
						}
						
						roundS3.setText("Player4 round score: " + ai3.getRoundScore() + " Player4 bid: " + ai3.getAIBid());
						scoreLabel3.setText("Player4 score: " + ai3.getScore());
					}
					
					
					scoreLabel.setText("Your score: "+ myPlayer.getScore()) ;
					scoreLabel1.setText("Player2 score:  " + ai1.getScore());
					cardPlayed.setText("");
					cardPlayed1.setText("");
					cardPlayed2.setText("");
					cardPlayed3.setText("");
					if(myPlayer.getScore() > 6)
					{
						roundLabel2.setText("You reached 7 points. Congratulation, you win the game! :) ");
						next.setDisable(true);
					}else if(ai1.getScore() > 6)
					{
						roundLabel2.setText("Player2 reached 7 points. You lost, let's try again! :( ");
						next.setDisable(true);
					}else if(ai2.getScore() > 6)
					{ 
						roundLabel2.setText("Player3 reached 7 points. You lost, let's try again! :( ");
						next.setDisable(true);
					}else if(ai3.getScore() > 6)
					{ 
						roundLabel2.setText("Player4 reached 7 points. You lost, let's try again!:( ");
						next.setDisable(true);
					}
				}else
				{
					sHand.setDisable(false);
					cardPlayed.setText("Your turn!!");
				}
				playC.setDisable(true);
			}
			});
		//exit
		e2.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				System.exit(0);
			}
		});
		c1 = new Button();
		c2 = new Button();
		c3 = new Button();
		c4 = new Button();
		c5 = new Button();
		c6 = new Button();
		
		EventHandler<ActionEvent> playACard = new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				if(bid1.isDisabled() == true)
				{
					Button b = (Button)event.getSource();
					cardPlayed.setText("You played: "+ b.getText());
					if(b == c1)
					{
						dealer.getDealer().addCardPlayed(myPlayer.getHand().getNthCard(0));
						if(dealer.getDealer().getTrump() == null)
							dealer.getDealer().setTrump(myPlayer.getHand().getNthCard(0).getsuit());
					}else if(b ==c2)
					{
						dealer.getDealer().addCardPlayed(myPlayer.getHand().getNthCard(1));
						if(dealer.getDealer().getTrump() == null)
							dealer.getDealer().setTrump(myPlayer.getHand().getNthCard(1).getsuit());
					}
					else if(b ==c3)
					{
						dealer.getDealer().addCardPlayed(myPlayer.getHand().getNthCard(2));
						if(dealer.getDealer().getTrump() == null)
							dealer.getDealer().setTrump(myPlayer.getHand().getNthCard(2).getsuit());
					}
					else if(b ==c4)
					{
						dealer.getDealer().addCardPlayed(myPlayer.getHand().getNthCard(3));
						if(dealer.getDealer().getTrump() == null)
							dealer.getDealer().setTrump(myPlayer.getHand().getNthCard(3).getsuit());
					}
					else if(b ==c5)
					{
						dealer.getDealer().addCardPlayed(myPlayer.getHand().getNthCard(4));
						if(dealer.getDealer().getTrump() == null)
							dealer.getDealer().setTrump(myPlayer.getHand().getNthCard(4).getsuit());
					}
					else
					{
						dealer.getDealer().addCardPlayed(myPlayer.getHand().getNthCard(5));
						if(dealer.getDealer().getTrump() == null)
							dealer.getDealer().setTrump(myPlayer.getHand().getNthCard(5).getsuit());
					}
					b.setText("");
					if(b.getText() == "")
						b.setDisable(true);
					
					Card ai1C,ai2C,ai3C;
					if(myPlayer.getNumPlayer() == 2)
					{
						if(dealer.getDealer().getWhoStart() == 1)
						{
							ai1C = ai1.playACard(dealer.getDealer().getCardPlayed(), dealer.getDealer().getTrump());
							cardPlayed1.setText("Player2 played: " + ai1C);
							dealer.getDealer().addCardPlayed(ai1C);
						}
					}else if(myPlayer.getNumPlayer() == 3)
					{
						if(dealer.getDealer().getWhoStart() == 1)
						{
							ai1C = ai1.playACard(dealer.getDealer().getCardPlayed(), dealer.getDealer().getTrump());
							ai2C = ai2.playACard(dealer.getDealer().getCardPlayed(), dealer.getDealer().getTrump());
							cardPlayed1.setText("Player4 played: " + ai1C);
							dealer.getDealer().addCardPlayed(ai1C);
							cardPlayed2.setText("Player3 played: " + ai2C);
							dealer.getDealer().addCardPlayed(ai2C);
						}else if(dealer.getDealer().getWhoStart()==3)
						{
							ai1C = ai1.playACard(dealer.getDealer().getCardPlayed(), dealer.getDealer().getTrump());
							cardPlayed1.setText("Player3 played: " + ai1C);
							dealer.getDealer().addCardPlayed(ai1C);
						}
					}else if(myPlayer.getNumPlayer()== 4)
					{
						if(dealer.getDealer().getWhoStart() == 1)
						{
							ai1C = ai1.playACard(dealer.getDealer().getCardPlayed(), dealer.getDealer().getTrump());
							ai2C = ai2.playACard(dealer.getDealer().getCardPlayed(), dealer.getDealer().getTrump());
							ai3C = ai3.playACard(dealer.getDealer().getCardPlayed(), dealer.getDealer().getTrump());
							cardPlayed1.setText("Player2 played: " + ai1C);
							dealer.getDealer().addCardPlayed(ai1C);
							cardPlayed2.setText("Player3 played: " + ai2C);
							dealer.getDealer().addCardPlayed(ai2C);
							cardPlayed3.setText("Player4 played: " + ai3C);
							dealer.getDealer().addCardPlayed(ai3C);
						}else if(dealer.getDealer().getWhoStart() == 4)
						{
							ai1C = ai1.playACard(dealer.getDealer().getCardPlayed(), dealer.getDealer().getTrump());
							ai2C = ai2.playACard(dealer.getDealer().getCardPlayed(), dealer.getDealer().getTrump());
							cardPlayed1.setText("Player2 played: " + ai1C);
							dealer.getDealer().addCardPlayed(ai1C);
							cardPlayed2.setText("Player3 played: " + ai2C);
							dealer.getDealer().addCardPlayed(ai2C);
						}else if(dealer.getDealer().getWhoStart() == 3)
						{
							ai1C = ai1.playACard(dealer.getDealer().getCardPlayed(), dealer.getDealer().getTrump());
							cardPlayed1.setText("Player2 played: " + ai1C);
							dealer.getDealer().addCardPlayed(ai1C);
						}
					}
					
				}else
				{
					cardPLabel.setText("You have to place you bid before play a card!");
					bidLabel.setText("no bid has selected yet!");
				}
				trumpLabel.setText("Trump Suit: " + dealer.getDealer().getTrump());
				c1.setDisable(true);
				c2.setDisable(true);
				c3.setDisable(true);
				c4.setDisable(true);
				c5.setDisable(true);
				c6.setDisable(true);
				playC.setDisable(false);
			}
		};
		c1.setOnAction(playACard);
		c2.setOnAction(playACard);
		c3.setOnAction(playACard);
		c4.setOnAction(playACard);
		c5.setOnAction(playACard);
		c6.setOnAction(playACard);
	
		//round finished scene buttons
		m3 = new Button("This round is finished, press continue to start next round");
		e = new Button("Exit Game");
		next = new Button("continue");
		
		next.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
				
				score = myPlayer.getScore();
				numPlayer = myPlayer.getNumPlayer();
				if(playingDeck.getCardNum() < 6*myPlayer.getNumPlayer())
				{
					playingDeck = new Deck();
					playingDeck.createDeck();
					playingDeck.shuffle();
				}
				myPlayer = new Player();
				myPlayer.setRoundScore(0);
				myPlayer.setNumPlayer(numPlayer);
				myPlayer.setScore(score);
				myPlayer.getCards(numPlayer,playingDeck);
				dealer.getDealer().initalBids();
				//p1Score.setText("Your total score: " + Integer.toString(score));
				
				score = ai1.getScore();
				ai1 = new AIPlayer();
				ai1.getAICards(numPlayer,playingDeck);
				ai1.setScore(score);
				ai1.setRoundScore(0);
				//ai1.initalBids();
				if(numPlayer > 2)
				{
					score = ai2.getScore();
					ai2 = new AIPlayer();
					ai2.getAICards(numPlayer,playingDeck);
					ai2.setScore(score);
					ai2.setRoundScore(0);
				}
				if(numPlayer > 3)
				{
					score = ai3.getScore();
					ai3 = new AIPlayer();
					ai3.getAICards(numPlayer,playingDeck);
					ai3.setScore(score);
					ai3.setRoundScore(0);
				}
				
				//set up card button
				c1.setText(myPlayer.cardLabel(0));
				c2.setText(myPlayer.cardLabel(1));
				c3.setText(myPlayer.cardLabel(2));
				c4.setText(myPlayer.cardLabel(3));
				c5.setText(myPlayer.cardLabel(4));
				c6.setText(myPlayer.cardLabel(5));
				cardPLabel.setText("");
				bidLabel.setText("");
				ai1BidLabel.setText("");
				ai2BidLabel.setText("");
				ai3BidLabel.setText("");
				allPassBid.setText("");
				roundLabel.setText("");
				cardPlayed.setText("");
				cardPlayed1.setText("");
				cardPlayed2.setText("");
				cardPlayed3.setText("");
				roundLabel2.setText("");
				trumpLabel.setText("");
				high.setText("");
				low.setText("");
				jack.setText("");
				all.setText("");
				points.setText("");
				roundS.setText("");
				roundS1.setText("");
				roundS2.setText("");
				roundS3.setText("");
				bid1.setDisable(false);
				bid2.setDisable(false);
				bid3.setDisable(false);
				bid4.setDisable(false);
				pass.setDisable(false);
				next.setDisable(true);
				
				counter = 0;
			}
		});
		e.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				System.exit(0);
			}
		});
		
//image setup
		Image pic = new Image("background3.jpg");
		
		//Start scene background
		ImageView v = new ImageView(pic);
		v.setFitHeight(600);
		v.setFitWidth(600);
		v.setPreserveRatio(true);
		v.setImage(pic);
		
		//game scene background
		ImageView v2 = new ImageView(pic);
		v2.setFitHeight(600);
		v2.setFitWidth(600);
		v2.setPreserveRatio(true);
		v2.setImage(pic);
		ImageView v3 = new ImageView(pic);
		v3.setFitHeight(600);
		v3.setFitWidth(600);
		v3.setPreserveRatio(true);
		v3.setImage(pic);
		v3.setLayoutX(550);
		
		//round scene background
		ImageView v4 = new ImageView(pic);
		v4.setFitHeight(600);
		v4.setFitWidth(600);
		v4.setPreserveRatio(true);
		v4.setImage(pic);
		ImageView v5 = new ImageView(pic);
		v5.setFitHeight(600);
		v5.setFitWidth(600);
		v5.setPreserveRatio(true);
		v5.setImage(pic);
		v5.setLayoutX(550);
		
//set group
		//start scene
		Group root = new Group();
		root.getChildren().addAll(v);
		
		//game scene
		Group gamePane = new Group();
		gamePane.getChildren().add(v2);
		gamePane.getChildren().add(v3);
		
		//round scene
		Group roundPane = new Group();
		roundPane.getChildren().add(v4);
		roundPane.getChildren().add(v5);
	
//Start scene
	
	//text1
	String welc = "Welcome to Pitch";
	Text we = new Text(welc);
	we.setLayoutX(100);
	we.setLayoutY(100);
	we.setFont(Font.font("", FontWeight.BOLD, FontPosture.REGULAR, 30));
	we.setFill(Color.WHITE);
	root.getChildren().add(we);
	
	//text2
	String t = "Let's get the game start";
	Text text = new Text(t);
	text.setLayoutX(100);
	text.setLayoutY(300);
	text.setFont(Font.font("", FontWeight.BOLD, FontPosture.REGULAR, 20));
	text.setFill(Color.WHITE);
	root.getChildren().add(text);
	
	
	//text3
	String t2 = "Choose numer of player";
	Text text2 = new Text(t2);
	text2.setLayoutX(100);
	text2.setLayoutY(150);
	text2.setFont(Font.font("", FontWeight.BOLD, FontPosture.REGULAR, 20));
	text2.setFill(Color.WHITE);
	l.setLayoutX(100);
	l.setLayoutY(200);
	l.setTextFill(Color.WHITE);
	root.getChildren().add(text2);
	root.getChildren().add(l);
	
	//button layout
	btn.setLayoutX(110);
	btn2.setLayoutX(110);
	btn2.setLayoutY(320);
	btn.setLayoutY(400);
	btn.setDisable(true);
	btn2.setDisable(true);
	changeP.setLayoutX(110);
	changeP.setLayoutY(360);
	changeP.setDisable(true);
	root.getChildren().add(btn);
	root.getChildren().add(btn2);
	root.getChildren().add(changeP);
	
	startLabel.setLayoutX(110);
	startLabel.setLayoutY(430);
	startLabel.setTextFill(Color.WHITE);
	root.getChildren().add(startLabel);
	
	//HBox choose number player layout
	HBox numPlayers = new HBox(10, x,y,z);//choose number of player
	numPlayers.setLayoutX(100);
	numPlayers.setLayoutY(170);
	root.getChildren().add(numPlayers);
	
//game Scene
	
	c1.setDisable(true);
	c2.setDisable(true);
	c3.setDisable(true);
	c4.setDisable(true);
	c5.setDisable(true);
	c6.setDisable(true);
	playC.setDisable(true);
	sGame.setDisable(true);
	sHand.setDisable(true);
	
	
	//bid
	HBox bid = new HBox(10,bid1,bid2,bid3,bid4,pass);//bids
	bid.setLayoutX(20);
	bid.setLayoutY(40);
	
	String bidt = "Place your bid";
	Text bidText = new Text(bidt);
	bidText.setLayoutX(20);
	bidText.setLayoutY(30);
	bidText.setFont(Font.font("", FontWeight.BOLD, FontPosture.REGULAR, 20));
	bidText.setFill(Color.WHITE);
	
	trumpLabel.setLayoutX(450);
	trumpLabel.setLayoutY(10);
	trumpLabel.setTextFill(Color.WHITE);
	trumpLabel.setFont(Font.font("Cambria", 15));
	//show player bid
	bidLabel.setLayoutX(20);
	bidLabel.setLayoutY(70);
	bidLabel.setTextFill(Color.WHITE);
	bidLabel.setFont(Font.font("Cambria", 15));
	
	ai1BidLabel.setLayoutX(20);
	ai1BidLabel.setLayoutY(90);
	ai1BidLabel.setTextFill(Color.WHITE);
	ai1BidLabel.setFont(Font.font("Cambria", 15));
	
	ai2BidLabel.setLayoutX(20);
	ai2BidLabel.setLayoutY(110);
	ai2BidLabel.setTextFill(Color.WHITE);
	ai2BidLabel.setFont(Font.font("Cambria", 15));
	
	ai3BidLabel.setLayoutX(20);
	ai3BidLabel.setLayoutY(130);
	ai3BidLabel.setTextFill(Color.WHITE);
	ai3BidLabel.setFont(Font.font("Cambria", 15));
	
	allPassBid.setLayoutX(20);
	allPassBid.setLayoutY(100);
	allPassBid.setTextFill(Color.RED);
	allPassBid.setFont(Font.font("Cambria", 20));
	
	gamePane.getChildren().add(allPassBid);
	gamePane.getChildren().add(ai1BidLabel);
	gamePane.getChildren().add(ai2BidLabel);
	gamePane.getChildren().add(ai3BidLabel);
	gamePane.getChildren().add(bidLabel);
	gamePane.getChildren().add(trumpLabel);
	gamePane.getChildren().add(bidText);
	gamePane.getChildren().add(bid);
	
	//start round
	sHand.setLayoutX(20);
	sHand.setLayoutY(430);
	gamePane.getChildren().add(sHand);
	
	sGame.setLayoutX(20);
	sGame.setLayoutY(150);
	gamePane.getChildren().add(sGame);
	
	playC.setLayoutX(20);
	playC.setLayoutY(500);
	gamePane.getChildren().add(playC);
	//cards
	String cardt = "Which card do you want to play?";
	Text cardText = new Text(cardt);
	cardText.setLayoutX(150);
	cardText.setLayoutY(450);
	cardText.setFont(Font.font("", FontWeight.BOLD, FontPosture.REGULAR, 20));
	cardText.setFill(Color.WHITE);
	
	HBox cards = new HBox(10,c1, c2, c3, c4, c5, c6);
	cards.setLayoutX(150);
	cards.setLayoutY(480);
	
	cardPLabel.setLayoutX(300);
	cardPLabel.setLayoutY(150);
	cardPLabel.setTextFill(Color.WHITE);
	cardPLabel.setFont(Font.font("Cambria", 17));
	
	cardPlayed.setLayoutX(150);
	cardPlayed.setLayoutY(450);
	cardPlayed.setTextFill(Color.WHITE);
	cardPlayed.setFont(Font.font("Cambria", 20));
	gamePane.getChildren().add(cardPlayed);
	HBox newAndExit = new HBox(10,s,e2);
	
	cardPlayed1.setLayoutX(10);
	cardPlayed1.setLayoutY(250);
	cardPlayed1.setTextFill(Color.WHITE);
	cardPlayed1.setFont(Font.font("Cambria", 20));
	gamePane.getChildren().add(cardPlayed1);
	
	cardPlayed2.setLayoutX(350);
	cardPlayed2.setLayoutY(60);
	cardPlayed2.setTextFill(Color.WHITE);
	cardPlayed2.setFont(Font.font("Cambria", 20));
	gamePane.getChildren().add(cardPlayed2);
	
	cardPlayed3.setLayoutX(650);
	cardPlayed3.setLayoutY(250);
	cardPlayed3.setTextFill(Color.WHITE);
	cardPlayed3.setFont(Font.font("Cambria", 20));
	gamePane.getChildren().add(cardPlayed3);
	
	newAndExit.setLayoutX(770);
	newAndExit.setLayoutY(10);
	
	roundS.setLayoutX(300);
	roundS.setLayoutY(200);
	roundS.setTextFill(Color.BLUE);
	roundS.setFont(Font.font("Cambria", 20));
	roundS1.setLayoutX(300);
	roundS1.setLayoutY(230);
	roundS1.setTextFill(Color.BLUE);
	roundS1.setFont(Font.font("Cambria", 20));
	roundS2.setLayoutX(300);
	roundS2.setLayoutY(260);
	roundS2.setTextFill(Color.BLUE);
	roundS2.setFont(Font.font("Cambria", 20));
	roundS3.setLayoutX(300);
	roundS3.setLayoutY(290);
	roundS3.setTextFill(Color.BLUE);
	roundS3.setFont(Font.font("Cambria", 20));
	gamePane.getChildren().add(roundS);
	gamePane.getChildren().add(roundS1);
	gamePane.getChildren().add(roundS2);
	gamePane.getChildren().add(roundS3);
	
	scoreLabel.setLayoutX(770);
	scoreLabel.setLayoutY(100);
	scoreLabel.setTextFill(Color.WHITE);
	scoreLabel1.setLayoutX(770);
	scoreLabel1.setLayoutY(120);
	scoreLabel1.setTextFill(Color.WHITE);
	scoreLabel2.setLayoutX(770);
	scoreLabel2.setLayoutY(140);
	scoreLabel2.setTextFill(Color.WHITE);
	scoreLabel3.setLayoutX(770);
	scoreLabel3.setLayoutY(160);
	scoreLabel3.setTextFill(Color.WHITE);
	
	gamePane.getChildren().add(scoreLabel1);
	gamePane.getChildren().add(scoreLabel2);
	gamePane.getChildren().add(scoreLabel3);
	gamePane.getChildren().add(scoreLabel);
	gamePane.getChildren().add(newAndExit);
	gamePane.getChildren().add(cardPLabel);
	gamePane.getChildren().add(cards);
	
	high.setLayoutX(300);
	high.setLayoutY(320);
	high.setTextFill(Color.RED);
	high.setFont(Font.font("Cambria", 20));
	
	low.setLayoutX(300);
	low.setLayoutY(350);
	low.setTextFill(Color.RED);
	low.setFont(Font.font("Cambria", 20));
	
	jack.setLayoutX(300);
	jack.setLayoutY(380);
	jack.setTextFill(Color.RED);
	jack.setFont(Font.font("Cambria", 20));
	
	points.setLayoutX(300);
	points.setLayoutY(410);
	points.setTextFill(Color.RED);
	points.setFont(Font.font("Cambria", 20));
	
	all.setLayoutX(300);
	all.setLayoutY(440);
	all.setTextFill(Color.RED);
	all.setFont(Font.font("Cambria", 20));
	gamePane.getChildren().add(high);
	gamePane.getChildren().add(low);
	gamePane.getChildren().add(jack);
	gamePane.getChildren().add(points);
	gamePane.getChildren().add(all);
	//round finished text
	roundLabel.setLayoutX(300);
	roundLabel.setLayoutY(150);
	roundLabel.setTextFill(Color.WHITE);
	roundLabel.setFont(Font.font("Cambria", 17));
	gamePane.getChildren().add(roundLabel);
	
	roundLabel2.setLayoutX(300);
	roundLabel2.setLayoutY(180);
	roundLabel2.setTextFill(Color.RED);
	roundLabel2.setFont(Font.font("Cambria", 20));
	gamePane.getChildren().add(roundLabel2);
	
	//next round
	next.setDisable(true);
	next.setLayoutX(900);
	next.setLayoutY(500);
	gamePane.getChildren().add(next);
	
	
//map
	scene = new Scene(root, 550, 560);//start scene
	scene2 = new Scene(gamePane, 1000, 560);//game scene
	sceneMap.put("welcome", scene);
	sceneMap.put("gamePlay", scene2);
	

	primaryStage.setScene(sceneMap.get("welcome"));
	primaryStage.setResizable(false);
	
	primaryStage.show();
	
	}
}

interface DealerType{
	public PitchDealer createDealer();
}
