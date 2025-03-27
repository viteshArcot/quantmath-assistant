import numpy as np
from sklearn.linear_model import LinearRegression
import yfinance as yf

def predict_stock(symbol):
    stock = yf.download(symbol, period="1y")
    if stock.empty:
        return {"error": "Invalid symbol"}
    
    X = np.arange(len(stock)).reshape(-1, 1)
    y = stock['Close'].values
    model = LinearRegression().fit(X, y)
    
    next_day = np.array([[len(stock)]])
    prediction = model.predict(next_day)[0]
    return prediction