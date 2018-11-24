package io.gearpump.streaming.kafka.lib

import java.time.Instant

import org.apache.gearpump._

/**
 * Decodes Kafka raw message of (key, value) bytes
 */
trait KafkaMessageDecoder extends java.io.Serializable {
  /**
   * @param key key of a kafka message, can be NULL
   * @param value value of a kafka message
   * @return a gearpump Message and watermark (i.e. event time progress)
   */
  def fromBytes(key: Array[Byte], value: Array[Byte]): MessageAndWatermark
}

case class MessageAndWatermark(message: Message, watermark: Instant)
