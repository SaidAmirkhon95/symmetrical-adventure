library ieee;
use ieee.std_logic_1164.all;

entity SR_Latch is
    port (
      S,R : in std_logic;
      Q,not_Q : out std_logic
    );
  end SR_Latch;

architecture Behavioral of SR_Latch is
    
	component nor_gate
	     port(
		     input1,input2 : in std_logic;
			 output : out std_logic
		 );
    end component;
	
    signal a,b : std_logic; 

begin

    sr1_instance : nor_gate port map (input1 => S, input2 => b, output => a);
	sr2_instance : nor_gate port map (input1 => R, input2 => a, output => b);
	
	Q <= b;
	not_Q <= a;

end Behavioral;
