package ua.blackjack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import ua.blackjack.model.*;

public class Controller {

	private final String cardBack = "_CARDBACK.png";

	private Player player = new Player("Player", 1000);
	private Dealer dealer = new Dealer("Dealer", 100000);
	private Game game = new Game();

	private int playerCards;
	private int playerBet;
	private int sumOfThePlayer;
	private int sumOfTheDealer;

	@FXML
	private ImageView dealerCard1;
	@FXML
	private ImageView dealerCard2;
	@FXML
	private ImageView deckContainer;
	@FXML
	private ImageView playerCard1;
	@FXML
	private ImageView playerCard2;
	@FXML
	private ImageView playerCard3;
	@FXML
	private ImageView playerCard4;
	@FXML
	private ImageView playerCard5;
	@FXML
	private ImageView playerCard6;
	@FXML
	private ImageView playerCard7;
	@FXML
	private Label playerMoney;
	@FXML
	private Label setBet;
	@FXML
	private Label labelNotice;
	@FXML
	private Slider choiseBet;
	@FXML
	private Button takeCardID;
	@FXML
	private Button passID;
	@FXML
	private Button putBetID;

	public void takeCard(ActionEvent actionEvent) {

		sumOfThePlayer = game.sumOfThePlayer(player);
		sumOfTheDealer = game.sumOfTheDealer(dealer);

		if (playerCards < 7) {
			game.givePlayerCard(player, game.getDeck().getCard(0));
			if (playerCards == 2) {
				playerCard3.setImage(new Image("file:resources/cards/" + player.getHand().get(2).toString() + ".png"));
			} else if (playerCards == 3) {
				playerCard4.setImage(new Image("file:resources/cards/" + player.getHand().get(3).toString() + ".png"));
			} else if (playerCards == 4) {
				playerCard5.setImage(new Image("file:resources/cards/" + player.getHand().get(4).toString() + ".png"));
			} else if (playerCards == 5) {
				playerCard6.setImage(new Image("file:resources/cards/" + player.getHand().get(5).toString() + ".png"));
			} else if (playerCards == 6) {
				playerCard7.setImage(new Image("file:resources/cards/" + player.getHand().get(6).toString() + ".png"));
			}

			playerCards++;
		} else if (playerCards == 7) {

			dealerCard2.setImage(new Image(("file:resources/cards/" + dealer.getHand().get(1).toString() + ".png")));

			if (sumOfTheDealer <= 21 && sumOfThePlayer <= 21) {

				if (sumOfTheDealer < sumOfThePlayer) {

					player.setPlayerMoney(player.getPlayerMoney() + playerBet);
					labelNotice.setText("You win!");
					playerMoney.setText(String.valueOf(player.getPlayerMoney()));
					choiseBet.setMax(player.getPlayerMoney());

				} else if (sumOfTheDealer > sumOfThePlayer) {

					player.setPlayerMoney(player.getPlayerMoney() - playerBet);
					labelNotice.setText("You lose!");
					playerMoney.setText(String.valueOf(player.getPlayerMoney()));
					choiseBet.setMax(player.getPlayerMoney());

				} else {

					labelNotice.setText("Draw!");

				}

			} else if (sumOfTheDealer > 21 && sumOfThePlayer <= 21) {

				player.setPlayerMoney(player.getPlayerMoney() + playerBet);
				labelNotice.setText("You win!");
				playerMoney.setText(String.valueOf(player.getPlayerMoney()));
				choiseBet.setMax(player.getPlayerMoney());

			} else if (sumOfTheDealer <= 21 && sumOfThePlayer > 21) {

				player.setPlayerMoney(player.getPlayerMoney() - playerBet);
				labelNotice.setText("You lose!");
				playerMoney.setText(String.valueOf(player.getPlayerMoney()));
				choiseBet.setMax(player.getPlayerMoney());

			}

			playerCards = 0;
			game.overwriteDeck();
			game.clearPlayerHand(player);
			game.clearDealerHand(dealer);
			choiseBet.setDisable(false);
			choiseBet.setMajorTickUnit((player.getPlayerMoney() / 10) + 1);
			putBetID.setDisable(false);
			takeCardID.setDisable(true);
			passID.setDisable(true);

		}

		sumOfThePlayer = game.sumOfThePlayer(player);

		if (sumOfThePlayer > 21) {
			player.setPlayerMoney(player.getPlayerMoney() - playerBet);
			labelNotice.setText("You lose!");
			playerMoney.setText(String.valueOf(player.getPlayerMoney()));
			choiseBet.setMax(player.getPlayerMoney());
			playerCards = 0;
			game.overwriteDeck();
			game.clearPlayerHand(player);
			game.clearDealerHand(dealer);
			choiseBet.setDisable(false);
			choiseBet.setMajorTickUnit((player.getPlayerMoney() / 10) + 1);
			putBetID.setDisable(false);
			takeCardID.setDisable(true);
			passID.setDisable(true);
		}

		if (player.getPlayerMoney() == 0) {
			player.setPlayerMoney(100);
			playerMoney.setText(String.valueOf(player.getPlayerMoney()));
			choiseBet.setMax(player.getPlayerMoney());
			choiseBet.setMajorTickUnit((player.getPlayerMoney() / 10) + 1);
		}

	}

	public void pass(ActionEvent actionEvent) {

		sumOfTheDealer = game.sumOfTheDealer(dealer);
		sumOfThePlayer = game.sumOfThePlayer(player);

		dealerCard2.setImage(new Image(("file:resources/cards/" + dealer.getHand().get(1).toString() + ".png")));

		if (sumOfTheDealer <= 21 && sumOfThePlayer <= 21) {

			if (sumOfTheDealer < sumOfThePlayer) {

				player.setPlayerMoney(player.getPlayerMoney() + playerBet);
				labelNotice.setText("You win!");
				playerMoney.setText(String.valueOf(player.getPlayerMoney()));
				choiseBet.setMax(player.getPlayerMoney());

			} else if (sumOfTheDealer > sumOfThePlayer) {

				player.setPlayerMoney(player.getPlayerMoney() - playerBet);
				labelNotice.setText("You lose!");
				playerMoney.setText(String.valueOf(player.getPlayerMoney()));
				choiseBet.setMax(player.getPlayerMoney());

			} else {

				labelNotice.setText("Draw!");

			}

		} else if (sumOfTheDealer > 21 && sumOfThePlayer <= 21) {

			player.setPlayerMoney(player.getPlayerMoney() + playerBet);
			labelNotice.setText("You win!");
			playerMoney.setText(String.valueOf(player.getPlayerMoney()));
			choiseBet.setMax(player.getPlayerMoney());

		} else if (sumOfTheDealer <= 21 && sumOfThePlayer > 21) {

			player.setPlayerMoney(player.getPlayerMoney() - playerBet);
			labelNotice.setText("You lose!");
			playerMoney.setText(String.valueOf(player.getPlayerMoney()));
			choiseBet.setMax(player.getPlayerMoney());

		}

		playerCards = 0;
		game.overwriteDeck();
		game.clearPlayerHand(player);
		game.clearDealerHand(dealer);
		choiseBet.setDisable(false);
		choiseBet.setMajorTickUnit((player.getPlayerMoney() / 10) + 1);
		putBetID.setDisable(false);
		takeCardID.setDisable(true);
		passID.setDisable(true);

		if (player.getPlayerMoney() == 0) {
			player.setPlayerMoney(100);
			playerMoney.setText(String.valueOf(player.getPlayerMoney()));
			choiseBet.setMax(player.getPlayerMoney());
		}
	}

	public void putBet(ActionEvent actionEvent) {

		playerBet = ((int) choiseBet.getValue());
		game.deckMix();
		game.givePlayerCard(player, game.getDeck().getCard(0));
		game.givePlayerCard(player, game.getDeck().getCard(0));
		game.giveDealerCard(dealer, game.getDeck().getCard(0));
		game.giveDealerCard(dealer, game.getDeck().getCard(0));

		deckContainer.setImage(new Image(("file:resources/cards/" + cardBack)));

		playerCard1.setImage(new Image(("file:resources/cards/" + player.getHand().get(0).toString() + ".png")));
		playerCard2.setImage(new Image(("file:resources/cards/" + player.getHand().get(1).toString() + ".png")));

		dealerCard1.setImage(new Image(("file:resources/cards/" + dealer.getHand().get(0).toString() + ".png")));
		dealerCard2.setImage(new Image(("file:resources/cards/" + cardBack)));

		playerCards = 2;

		setBet.setText(String.valueOf(playerBet));
		labelNotice.setText("");

		choiseBet.setDisable(true);
		putBetID.setDisable(true);
		takeCardID.setDisable(false);
		passID.setDisable(false);
		playerCard3.setImage(null);
		playerCard4.setImage(null);
		playerCard5.setImage(null);
		playerCard6.setImage(null);
		playerCard7.setImage(null);

		// check is ti blackJack
		sumOfThePlayer = game.sumOfThePlayer(player);

		if (sumOfThePlayer == 21) {
			game.overwriteDeck();
			game.clearPlayerHand(player);
			game.clearDealerHand(dealer);
			choiseBet.setDisable(false);
			putBetID.setDisable(false);
			takeCardID.setDisable(true);
			passID.setDisable(true);
			labelNotice.setText("You win! BLACKJACK");
			player.setPlayerMoney(player.getPlayerMoney() + (playerBet * 2));
			playerMoney.setText(String.valueOf(player.getPlayerMoney()));
			choiseBet.setMax(player.getPlayerMoney());
		}

	}

}
