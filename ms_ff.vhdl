library ieee;
use ieee.std_logic_1164.all;

entity ms_ff is
    port (
      d, clk: in std_logic;
      Q, not_Q : out std_logic
    );
  end ms_ff;

architecture behavioral of ms_ff is

    component not_gate 
	   port(
	       input1 : in std_logic;
		   not_output : out std_logic
	   );
	end component; 
	
	component D_Latch
	   port(
	       D, clk : in std_logic;
		   Q, not_Q : out std_logic
	   );
	end component;
	   
    signal not_signal : std_logic;
	signal N1 : std_logic;
	signal master_notout : std_logic;
	signal q_result : std_logic;
	signal q_notresult : std_logic;

begin

    not_sequence : not_gate port map (input1 => clk, not_output => not_signal);
	d_master : D_Latch port map (D => d, clk => not_signal, Q => N1, not_Q => master_notout);
	d_slave : D_Latch port map (D => N1, clk => clk, Q => q_result, not_Q => q_notresult);
	Q <= q_result;
	not_Q <= q_notresult; 
	

end behavioral ;