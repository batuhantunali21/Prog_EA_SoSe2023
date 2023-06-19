package com.example.prog2.unity;

public class unitycode {

    /** using System;
     using System.Collections;
     using System.Collections.Generic;
     using System.Net;
     using System.Net.Sockets;
     using System.Text;
     using UnityEngine;
     using System.Threading;
     using System.IO;

     [System.Serializable]
     public class PositionData
     {
     public float x;
     public float y;
     public float z;

     public PositionData(Vector3 position)
     {
     x = position.x;
     y = position.y;
     z = position.z;
     }
     }

     public class DroneServer : MonoBehaviour
     {
     private const string HOST_NAME = "127.0.0.1";
     private const int LISTENER_PORT = 10666;
     private const int CLIENT_PORT = 10668;
     private const int BUFFER_SIZE = 1024;
     private const string LISTENER_INFO = "Server wartet auf Client-Anfrage...";
     private const string REQUEST_INFO = "Folgende Nachricht vom Client empfangen: ";
     private const string STANDARD_DATA = "Ping vom Server";

     [SerializeField] public GameObject drone;

     private Vector3 dronePosition;
     private TcpListener tcpListener;
     private Thread tcpListenerThread;
     private TcpClient connectedTcpClient;
     private NetworkStream stream;
     private string droneData;
     private const string JSON_FILE_PATH = "Coordinates.json";

     private TcpClient javaFxClient;
     private NetworkStream javaFxStream;

     private void Start()
     {
     this.tcpListenerThread = new Thread(new ThreadStart(ListenForIncommingRequests));
     this.tcpListenerThread.IsBackground = true;
     this.tcpListenerThread.Start();

     connectedTcpClient = new TcpClient();
     connectedTcpClient.Connect(HOST_NAME, LISTENER_PORT);
     stream = connectedTcpClient.GetStream();
     SendMessageToServer("Hallo Server!");

     // Stellen Sie eine Verbindung zum JavaFX-Server her und initialisieren Sie den javaFxStream
     ConnectToJavaFXServer();
     if (javaFxClient.Connected)
     {
     Debug.Log("Successfully connected to JavaFX server");
     }

     // Starten Sie die Coroutine zur Positionsaktualisierung
     StartCoroutine(UpdateDronePosition());
     Debug.Log("Started coroutine UpdateDronePosition");
     }

     private void SendMessageToServer(string message)
     {
     byte[] messageBytes = Encoding.ASCII.GetBytes(message);
     stream.Write(messageBytes, 0, messageBytes.Length);
     Debug.Log("Message sent to server: " + message);
     }

     private void ConnectToJavaFXServer()
     {
     try
     {
     // Stellen Sie eine Verbindung zum JavaFX-Server her
     javaFxClient = new TcpClient(HOST_NAME, CLIENT_PORT);

     // Initialisieren Sie den javaFxStream
     javaFxStream = javaFxClient.GetStream();
     }
     catch (Exception e)
     {
     Debug.LogError("Failed to connect to JavaFX server: " + e.Message);
     }
     }

     private void SendCoordinatesToJavaFX(string data)
     {
     try
     {
     // Überprüfen Sie, ob der javaFxStream initialisiert wurde
     if (javaFxStream != null)
     {
     // Konvertieren Sie die Koordinaten in Bytes
     byte[] messageBytes = Encoding.ASCII.GetBytes(data);

     // Senden Sie die Bytes an den JavaFX-Server
     javaFxStream.Write(messageBytes, 0, messageBytes.Length);
     Debug.Log("Coordinates sent to JavaFX: " + data);
     }
     else
     {
     Debug.LogError("javaFxStream is not initialized!");
     }
     }
     catch (Exception e)
     {
     Debug.LogError("Error sending coordinates to JavaFX: " + e.Message);
     }
     }

     private void OnDestroy()
     {
     if (stream != null)
     {
     stream.Close();
     }

     if (connectedTcpClient != null)
     {
     connectedTcpClient.Close();
     }

     if (javaFxStream != null)
     {
     javaFxStream.Close();
     }

     if (javaFxClient != null)
     {
     javaFxClient.Close();
     }
     }

     private IEnumerator UpdateDronePosition()
     {
     while (true)
     {
     // Überprüfen Sie, ob das GameObject "drone" existiert
     if (drone != null)
     {
     // Aktualisieren Sie die gespeicherte Position der Drohne im Hauptthread
     dronePosition = drone.transform.position;

     // Aktualisieren Sie die Drohnenposition in regelmäßigen Abständen
     string data = GetData();
     SendMessageToServer(data);
     Debug.Log("Data sent to server: " + data);

     // Speichern Sie die empfangenen Koordinaten als JSON-Datei
     SaveCoordinatesAsJson(data);

     // Senden Sie die Koordinaten an Ihren JavaFX-Server
     SendCoordinatesToJavaFX(data);
     }
     else
     {
     Debug.LogWarning("GameObject 'drone' not found!");
     }

     // Warten Sie für eine gewisse Zeit, bevor Sie die Position erneut aktualisieren
     yield return new WaitForSeconds(0.5f);
     }
     }

     private void ListenForIncommingRequests()
     {
     try
     {
     this.tcpListener = new TcpListener(IPAddress.Parse(HOST_NAME), LISTENER_PORT);
     this.tcpListener.Start();
     Debug.Log(LISTENER_INFO);

     Byte[] bytes = new Byte[BUFFER_SIZE];
     while (true)
     {
     using (this.connectedTcpClient = tcpListener.AcceptTcpClient())
     {
     using (NetworkStream stream = this.connectedTcpClient.GetStream())
     {
     int length;
     while ((length = stream.Read(bytes, 0, bytes.Length)) != 0)
     {
     var incommingData = new byte[length];
     Array.Copy(bytes, 0, incommingData, 0, length);
     string clientMessage = Encoding.ASCII.GetString(incommingData);
     Debug.Log(REQUEST_INFO + clientMessage);
     }
     }
     }
     }
     }
     catch (SocketException socketException)
     {
     Debug.Log(socketException.ToString());
     }
     }

     private void SaveCoordinatesAsJson(string data)
     {
     try
     {
     // Erstellen oder überschreiben Sie die JSON-Datei mit den empfangenen Koordinaten
     File.WriteAllText(JSON_FILE_PATH, data);
     Debug.Log("Coordinates saved as JSON file: " + JSON_FILE_PATH);
     }
     catch (Exception e)
     {
     Debug.LogError("Failed to save coordinates as JSON file: " + e.Message);
     }
     }

     private string GetData()
     {
     PositionData positionData = new PositionData(dronePosition);
     string json = JsonUtility.ToJson(positionData);
     return json;
     }
     }
*/
}