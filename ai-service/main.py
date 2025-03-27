from fastapi import FastAPI
import numpy as np
from model import predict_stock

app = FastAPI()

@app.get("/predict/{symbol}")
async def predict(symbol: str):
    prediction = predict_stock(symbol)
    return prediction

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)