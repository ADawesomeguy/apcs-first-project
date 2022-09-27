
public class Main {
  public static void main(String[] args) {
    try {
    IO.scrollPrint(
      """
 **               ** **                      ********                                 ******** **                      **             **
/**              /**//                      /**/////                                 **////// //                      /**            /**
/** *******      /** **  ******   *******   /**        ******   ****** **********   /**        ** **********  **   ** /**  ******   ******  ******  ******
/**//**///**  ******/** //////** //**///**  /*******  //////** //**//*//**//**//**  /*********/**//**//**//**/**  /** /** //////** ///**/  **////**//**//*
/** /**  /** **///**/**  *******  /**  /**  /**////    *******  /** /  /** /** /**  ////////**/** /** /** /**/**  /** /**  *******   /**  /**   /** /** /
/** /**  /**/**  /**/** **////**  /**  /**  /**       **////**  /**    /** /** /**         /**/** /** /** /**/**  /** /** **////**   /**  /**   /** /**
/** ***  /**//******/**//******** ***  /**  /**      //********/***    *** /** /**   ******** /** *** /** /**//****** ***//********  //** //****** /***
// ///   //  ////// //  //////// ///   //   //        //////// ///    ///  //  //   ////////  // ///  //  //  ////// ///  ////////    //   //////  ///

      """, 300
    );
      Thread.sleep(5000);
    } catch (Exception e) {
      System.out.println(e);
    }
    
    //accesses files
    Prompt prompt = new Prompt();
    Player player = new Player();
    Shop shop = new Shop();
    //creates Gameboard
    GameBoard board = new GameBoard(5, 5, player);
    
    //try and catch handles exceptions, and prevents them from crashing code
    try {
    //loops the program to keep resetting/updating the board;
      while (true) {
        if (player.getSustenance() <= 0) break;
        IO.clearTerm();
        IO.scrollPrint("Current amount of cash: " + player.getMoney() + "₹\n");
        IO.scrollPrint("Sustenance level: " + player.getSustenance() + "%\n");
        IO.scrollPrint("Days alive: " + board.getDays() + "\n");
        board.checkPlayerLocation(player);
        System.out.print(board);
        prompt.giveInitialChoices(player, shop, board);
        player.setSustenance(player.getSustenance() - (int)(Math.random() * 15));
        board.incrementDays();
      }
      
      String message = new String();
      if (board.getDays() < 5) {
        message = "You went out pretty easily...";
      } else if (board.getDays() < 10) {
        message = "You put up a bit of a fight!";
      } else {
        message = "Your extreme aptitude for survival couldn't keep you alive long enough.";
      }
      IO.scrollPrint(String.format("%s You survived %d days.", message, board.getDays()));
    } catch (Exception e) {
      System.out.println(e);
    }
  }
} //end Main Class