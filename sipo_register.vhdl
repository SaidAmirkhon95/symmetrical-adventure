library ieee;
use ieee.std_logic_1164.all;

-- ein serieler Input, 8 bit parallel Output
entity sipo_register is
    port(
        serial_in, clear, clock : in std_logic;
        Q : out std_logic_vector(3 downto 0)
    );
end sipo_register;

architecture rtl of sipo_register is
    component DFlipFlop is 
        port (
            d, clk, reset: in std_logic;
            Q : out std_logic
        );
    end component;
    
	signal p : std_logic_vector(0 to 3);
    --signal Q1 : std_logic;
	--signal Q2 : std_logic;
	--signal Q3 : std_logic;
	--signal Q4 : std_logic;
	--signal Q5 : std_logic;
	--signal Q6 : std_logic;
	--signal Q7 : std_logic;
	--signal Q8 : std_logic;
begin
   --for p in 0 to 3 loop
    FF1 : DFlipFlop port map (d => serial_in, clk => clock, reset => clear, Q => p(0));
	FF2 : DFlipFlop port map (d => p(0), clk => clock, reset => clear, Q => p(1));
	FF3 : DFlipFlop port map (d => p(1), clk => clock, reset => clear, Q => p(2));
	FF4 : DFlipFlop port map (d => p(2), clk => clock, reset => clear, Q => p(3));
   --end loop p; 
	--FF5 : DFlipFlop port map (d => Q4, clk => clock, reset => clear, Q => Q5);
	--FF6 : DFlipFlop port map (d => Q5, clk => clock, reset => clear, Q => Q6);
	--FF4 : DFlipFlop port map (d => Q6, clk => clock, reset => clear, Q => Q7);
	--FF4 : DFlipFlop port map (d => Q7, clk => clock, reset => clear, Q => Q8);
	Q(0) <= p(0);
	Q(1) <= p(1);
	Q(2) <= p(2);
    Q(3) <= p(3);
	
end rtl;
