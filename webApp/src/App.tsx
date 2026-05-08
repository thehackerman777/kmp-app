import React, { useEffect, useState } from 'react'

interface Greeting {
  message: string
  platform: string
  timestamp: number
}

function App() {
  const [greeting, setGreeting] = useState<Greeting | null>(null)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    // Try to fetch from backend (fallback to local greeting)
    fetch('/api/greeting')
      .then(res => res.json())
      .then(data => setGreeting(data))
      .catch(() => {
        setGreeting({
          message: '¡Hola desde la Web!',
          platform: `React + Vite (${navigator.platform})`,
          timestamp: Date.now()
        })
      })
  }, [])

  return (
    <div className="container">
      <div className="card">
        <div className="emoji">🌐</div>
        <h1>KMP App — Web</h1>
        {error && <p className="error">{error}</p>}
        {greeting && (
          <>
            <p className="message">{greeting.message}</p>
            <p className="platform">Platform: {greeting.platform}</p>
            <p className="time">
              {new Date(greeting.timestamp).toLocaleString('es-CO')}
            </p>
          </>
        )}
        <div className="meta">
          <span>Kotlin Multiplatform</span>
          <span>+</span>
          <span>React + Vite</span>
        </div>
      </div>
    </div>
  )
}

export default App
