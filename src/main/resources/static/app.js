const API = "/api";

document.addEventListener("DOMContentLoaded", function() {
    loadTransactions();
});

async function loadTransactions() {
    const response = await fetch(API + "/transactions");
    const transactions = await response.json();
    displayTransactions(transactions);
    updateBalance(transactions);
}

function displayTransactions(transactions) {
    const list = document.getElementById("transactionList");
    if (transactions.length === 0) {
        list.innerHTML = '<div class="empty-state">No transactions yet. Add one above! 👆</div>';
        return;
    }
    list.innerHTML = transactions.map(t => `
        <div class="transaction-item ${t.type.toLowerCase()}">
            <div class="transaction-info">
                <span class="transaction-title">${t.title}</span>
                <span class="transaction-meta">${t.category} • ${t.date}</span>
            </div>
            <div class="transaction-right">
                <span class="${t.type === 'INCOME' ? 'amount-income' : 'amount-expense'}">
                    ${t.type === 'INCOME' ? '+' : '-'}$${t.amount.toFixed(2)}
                </span>
                <button class="delete-btn" onclick="deleteTransaction(${t.id})">Delete</button>
            </div>
        </div>
    `).join('');
}

function updateBalance(transactions) {
    let income = 0;
    let expense = 0;
    for (const t of transactions) {
        if (t.type === "INCOME") {
            income += t.amount;
        } else {
            expense += t.amount;
        }
    }
    const balance = income - expense;
    document.getElementById("totalBalance").textContent = "$" + balance.toFixed(2);
    document.getElementById("totalIncome").textContent = "$" + income.toFixed(2);
    document.getElementById("totalExpense").textContent = "$" + expense.toFixed(2);
}

async function addTransaction() {
    const title    = document.getElementById("title").value;
    const amount   = document.getElementById("amount").value;
    const type     = document.getElementById("type").value;
    const category = document.getElementById("category").value;
    const date     = document.getElementById("date").value;

    if (!title || !amount || !date) {
        alert("Please fill in all fields!");
        return;
    }

    const transaction = {
        title: title,
        amount: parseFloat(amount),
        type: type,
        category: category,
        date: date
    };

    await fetch(API + "/transactions", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(transaction)
    });

    document.getElementById("title").value = "";
    document.getElementById("amount").value = "";
    document.getElementById("date").value = "";

    loadTransactions();
}

async function deleteTransaction(id) {
    await fetch(API + "/transactions/" + id, {
        method: "DELETE"
    });
    loadTransactions();
}

document.getElementById("addBtn").addEventListener("click", addTransaction);