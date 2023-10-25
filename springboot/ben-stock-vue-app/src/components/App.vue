<template>
  <div id="app">
    <h1 class="caption p-4">Stock Order Book</h1>
    <div class="order-book-container">
      <div class="order-book-tables">
        <div class="order-book-buy">
          <el-table :data="buyOrders">
            <el-table-column label="Shares" prop="share" align="center"></el-table-column>
            <el-table-column label="Buy (Bid)" prop="price" align="center"></el-table-column>
          </el-table>
        </div>
        <div class="order-book-sell">
          <el-table :data="sellOrders">
            <el-table-column label="Sell (Ask)" prop="price" align="center"></el-table-column>
            <el-table-column label="Shares" prop="share" align="center"></el-table-column>
          </el-table>
        </div>
      </div>

    <!-- <div><klineChart/></div> -->
    <!-- div, import, components return -->

      <div class="trade-record">
        <el-table :data="tradeRecords">
          <el-table-column label="Time" prop="time" align="center"></el-table-column>
          <el-table-column label="Price" prop="price" align="center"></el-table-column>
          <el-table-column label="Quantity" prop="quantity" align="center"></el-table-column>
        </el-table>
      </div>



      <div class="order-form">
        <el-form :model="form">
          <!-- Action -->
          <el-row class="button-header">Action</el-row>
          <el-row>
            <el-col class="button-wrapper">
              <el-button v-for="(option, index) in buySellOptions" :key="index"
                :class="{ 'selected': buySellSelectedOption === index }" @click="buySellSelectOption(index)">
                <span>{{ option }}</span>
              </el-button>
            </el-col>
          </el-row>
          <!-- Order Type -->
          <el-row class="button-header">Order Type</el-row>
          <el-row>
            <el-col class="button-wrapper"> <!-- Add class "align-left" for left alignment -->
              <el-button v-for="(option, index) in orderTypeOptions" :key="index"
                :class="{ 'selected': orderTypeSelectedOption === index }" @click="orderTypeSelectOption(index)">
                <span>{{ option }}</span>
              </el-button>
            </el-col>
          </el-row>
          <!-- price -->
          <el-row class="button-header">Price</el-row>
          <el-row>
            <div class="custom-input-number">
              <el-input-number v-model="form.price_input" :min="0" :max="1000" :step="0.05"></el-input-number>
            </div>
          </el-row>
          <!-- shares -->
          <el-row class="button-header">Shares</el-row>
          <el-row>
            <div class="custom-input-number">
              <el-input-number v-model="form.share_input" :min="0" :max="10000" :step="1"></el-input-number>
            </div>
          </el-row>
          <!-- Total Order value -->
          <el-row class="button-header">Total Order Amount</el-row>
          <el-row>
            <div class="custom-input-order-value">
              <!-- <el-input-number v-model="form.total_order_value_input" :min="1" :max="10000000000"
                :controls="false"></el-input-number> -->
                {{total_order_value_input}}
            </div>
          </el-row>
          <el-row>
            <div class="place-order-button">
              <el-button type="primary" @click="placeOrder">Place Order</el-button>
            </div>
          </el-row>
        </el-form>
      </div>
    </div>
  </div>
</template>

<style>
body::before {
  content: '';
  background-image: url('/stock_background.png');
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  opacity: 0.93;
  /* Adjust the opacity level (0.0 to 1.0) */
  z-index: -1;
}

.caption {
  text-align: center;
  font-size: 33px;
  font-weight: bold;
  color: rgb(237, 230, 230);
  width: 100%;
}

.order-book-container {
  display: flex;
  justify-content: space-between;
  border-radius: 10px;
  border-style: groove;
}

.order-book-tables {
  width: 40%;
  display: flex;
  justify-content: space-between;
  margin-left: 30px;
}

.order-book-buy {
  /* display: flex;
  align-items: top;
  justify-content: center; */
  width: 47%;
}

.order-book-sell {
  /* display: flex;
  align-items: top;
  justify-content: center; */
  width: 47%;
}

.trade-record {
  /* display: flex;
  align-items: baseline;
  justify-content: center; */
  width: 30%;
  height: 560px;
  overflow: auto;

}

/* Styling for the order form and panel */
.order-form {
  width: 20%;
  display: flex;
  flex-direction: column;
  align-items: center;
  /* Center content horizontally */
  margin-right: 50px;
  background-color: #f7f7f7;
  /* Light gray background */
  border: 2px solid #b2bfe0;
  border-radius: 5px;
  padding: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  /* Box shadow for depth */
}

.order-panel {
  width: 97%;
  /* Make the panel 100% width within the order-form */
  margin-bottom: 10px;
}

.order-panel label {
  font-weight: bold;
  color: #333;
  /* Dark text color */
}

.order-panel select,
.order-panel input {
  padding: 10px;
  border: 1.8px solid #e46c25;
  border-radius: 10px;
  width: 100%;
  /* Full width input fields */
  margin-bottom: 20px;
}

.button-header {

  color: rgb(92, 99, 99);
  font-size: 20px;
}

.button-wrapper .el-button {
  font-size: 15px;
  padding: 28px 60px;
  width: 133px;
  /* Set the fixed width as needed */
  height: 65px;
  margin-bottom: 15px;
  margin-top: 15px;
  border: 1.5px solid #e7dfdf;
  border-radius: 20px;
  text-align: left;
  background-color: #f6f9f7;
  transition: border-color 0.2s;

  /* 咁寫先有選完柜柜 */
  &.selected {
    border-color: #1b439b;
    border-width: 1.5px;
    color: #1b439b;
  } 

}

.custom-input-number {
  display: flex;
  align-items: center;
  justify-content: center;
  /* Align items to the right */
  border: 1.5px solid #1b439b;
  border-radius: 25px;

  margin-bottom: 15px;
  margin-top: 15px;

  background-color: #f7f7f7;
  color: #333;
  font-size: 18px;
  /* Increase the font size for a larger input box */
  width: 280px;
  /* Width of the container */
  height: 65px;
  /* Height of the container */
}


.custom-input-number .el-input {
  border: none;
  /* Remove the border from the inner input */
  margin: 0;
  /* Remove any margin */
  padding: 0;
  /* Remove any padding */
}

.custom-input-number .el-input-number__increase {
  background-color: #4771b8;
  color: white;
  border: 1.5px solid #3850b9;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  margin-right: -50px;
  margin-top: -5px;
  font-size: 20px;
  font-weight: 300;
}

.custom-input-number .el-input-number__decrease {
  background-color: #4771b8;
  color: white;
  border: 1.5px solid #3850b9;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  margin-left: -50px;
  margin-top: -5px;
  font-size: 20px;
  font-weight: bold;
}

.custom-input-order-value {
  width: 200px;
  margin-bottom: 15px;
  margin-top: 15px;
}

.custom-input-order-value .el-input {
  border: none;
  box-shadow: none;
}

.custom-input-order-value .el-input-number__input {
  border: 1.5px solid #1543b7;
  border-radius: 25px;
  background-color: #f7f7f7;
  color: #333;
  font-size: 30px;
  max-width: 600px;
  height: 70px;
  text-align: left;
  /* Align the text input to the left */

}

.place-order-button {
  display: flex;
  justify-content: center;
}

.place-order-button .el-button {
  background-color: #1b439b;
  /* Text color */
  border: none;
  /* Remove the button border */
  border-radius: 25px;
  font-size: 15px;
  width: 280px;
  height: 65px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 5px;
  margin-top: 10px;
}
</style>

<script>
import { ref, computed, onMounted } from 'vue';
import axios from 'axios';
// import { onMounted } from '@vue/composition-api';

// import klineChart from './model/klineChart.vue';

export default {
  name: 'App',

  // components: {
  //   klineChart,
  // },

  setup() {
    const form = ref({
      share_input: 100,
      price_input: 50.00,
      // total_order_value_input: null
    });

    const total_order_value_input = computed(() => {
      return form.value.share_input * form.value.price_input;
    });

    const buyOrders = ref([
      // { price: 51.9, share: 300 },
      // { price: 51.5, share: 150 },
      // { price: 51.0, share: 200 },
    ]);

    const sellOrders = ref([
      // { price: 52.0, share: 300 },
      // { price: 52.5, share: 150 },
      // { price: 53.0, share: 200 },
    ]);

    const tradeRecords = ref([]);

    const fetchDataFromApi = async () => {
      try {
        const response = await axios.get('http://localhost:8088/api/v2/orders');
        const apiData = response.data;
        buyOrders.value = apiData.filter(order => order.buySell === 'BUY').map(order => ({
          price: order.price,
          share: order.quantity,
        })).reverse().slice(0, 5);
        sellOrders.value = apiData.filter(order => order.buySell === 'SELL').map(order => ({
          price: order.price,
          share: order.quantity,
        })).slice(0, 5);
        const response2 = await axios.get('http://localhost:8088/api/v2/traderecord');
        const apiData2 = response2.data;
        tradeRecords.value = apiData2.map(record => {
          const a = record.localDateTime.split('T');
          const time = a[1];
          return {
            time: time,
            price: record.price,
            quantity: record.quantity,
          };
        }).reverse();
      } catch (error) {
        console.error('Error fetching data from the API:', error);
      }
    };

    onMounted(() => {
      fetchDataFromApi();
    });

    const refreshInterval = setInterval(() => {
      fetchDataFromApi();
    }, 10000);

    // Buy Sell Option
    const buySellSelectedOption = ref(null);
    const buySellOptions = ['Buy', 'Sell'];
    const buySellSelectOption = (buySellIndex) => {
      buySellSelectedOption.value = buySellIndex;
    };

    // Order Type Option
    const orderTypeSelectedOption = ref(null);
    const orderTypeOptions = ['Market', 'Limit'];
    const orderTypeSelectOption = (orderTypeIndex) => {
      orderTypeSelectedOption.value = orderTypeIndex;
      if (orderTypeSelectedOption.value === 0) {
        // form.price_input = 0; // 想選market -> price_input 變 0
        // total_order_value_input = 0;
      }
    };

    const placeOrder = async () => {
      console.log('Placing order...');
      console.log('Price Input:', form.value.price_input);
      console.log('Share Input:', form.value.share_input);
      console.log('OrderType Selected Option:', buySellSelectedOption.value);
      console.log('Buy Sell Selected Option:', orderTypeSelectedOption.value);

      const buySell = buySellSelectedOption.value === 0 ? 'BUY' : 'SELL';
      const price = form.value.price_input;
      const quantity = form.value.share_input;

      const apiUrlMarket = `http://localhost:8088/api/v2/marketorder?stockName=ABC&buySell=${buySell}&quantity=${quantity}`;
      const apiUrlLimit = `http://localhost:8088/api/v2/limitorder?stockName=ABC&buySell=${buySell}&price=${price}&quantity=${quantity}`;

      // const postData = {
      //   stockName: "ABC",
      //   buySell: buySellOptions[buySellSelectedOption.value],
      //   price: form.price_input,
      //   quantity: form.share_input,
      // }

      if (orderTypeSelectedOption.value === 0) {
        console.log('orderTypeSelectedOption.value:', 0);
        axios.post(apiUrlMarket)
        .then((response) => {
          console.log('Market order successfully:', response.data);
        })
        .catch((error) => {
          console.error('Error:', error);
        });
      } else {
        console.log('orderTypeSelectedOption.value:', 1);
        axios.post(apiUrlLimit)
        .then((response) => {
          console.log('Limit order successfully:', response.data);
        })
        .catch((error) => {
          console.error('Error:', error);
        });
      }
      // Implement your order placement logic here

    };

    return {
      form,
      total_order_value_input,
      buyOrders, sellOrders, tradeRecords,
      buySellSelectedOption, buySellOptions, buySellSelectOption,
      orderTypeSelectedOption, orderTypeOptions, orderTypeSelectOption,
      placeOrder,
      // klineChart,
    };
  },
};
</script>
